package com.hywa.pricepublish.service.collect.impl;

import com.hywa.pricepublish.common.utils.DateUtils;
import com.hywa.pricepublish.common.utils.UUIDUtils;
import com.hywa.pricepublish.dao.entity.*;
import com.hywa.pricepublish.dao.mapper.MarketRecentUseMapper;
import com.hywa.pricepublish.dao.mapper.PriceCollectionMapper;
import com.hywa.pricepublish.dao.mapper.ProductMapper;
import com.hywa.pricepublish.dao.mapper.ProductRecentUseMapper;
import com.hywa.pricepublish.event.PriceCollectHistoryCreateEvent;
import com.hywa.pricepublish.representation.PriceCollectionRep;
import com.hywa.pricepublish.representation.PriceCollectionReps;
import com.hywa.pricepublish.representation.ProductRep;
import com.hywa.pricepublish.service.collect.PriceCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PriceCollectionServiceImpl implements PriceCollectionService {

    @Autowired
    private PriceCollectionMapper priceCollectionMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRecentUseMapper productRecentUseMapper;

    @Autowired
    private MarketRecentUseMapper marketRecentUseMapper;

    @Autowired
    private ApplicationContext context;

    @Override
    @Transactional
    public void save(String userId, String dateTime, String marketId, String marketName, List<ProductRep> reps) {
        String historyId = UUIDUtils.randomUUID();
        List<PriceCollection> priceCollections = new ArrayList<>();
        List<ProductRecentUse> productRecentUses = new ArrayList<>();
        reps.forEach(productRep -> {
            PriceCollection priceCollection = new PriceCollection();
            priceCollection.setCreateUser(userId);
            priceCollection.setId(UUIDUtils.randomUUID());
            priceCollection.setMarketId(marketId);
            priceCollection.setProductId(productRep.getProductId());
            priceCollection.setPrice(productRep.getPrice());
            priceCollection.setHistoryId(historyId);
            priceCollection.setUnit(productRep.getUnit());
            try {
                priceCollection.setCreateTime(DateUtils.stringToDate(dateTime, DateUtils.DEFAULT_FORMAT));
                priceCollection.setUpdateTime(DateUtils.stringToDate(dateTime, DateUtils.DEFAULT_FORMAT));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            priceCollections.add(priceCollection);
            productRecentUses.add(new ProductRecentUse(productRep.getProductId(), userId));
        });
        priceCollectionMapper.insertBatch(priceCollections);
        saveCollectHistory(dateTime, marketName, historyId, userId);
        collectProductRecentUse(productRecentUses);
        collectMarketRecentUse(userId, marketId);
    }

    private void collectMarketRecentUse(String userId, String marketId) {
        MarketRecentUse recentUse = new MarketRecentUse();
        recentUse.setId(UUIDUtils.randomUUID());
        recentUse.setMarketId(marketId);
        recentUse.setUserId(userId);
        marketRecentUseMapper.insert(recentUse);
    }

    private void collectProductRecentUse(List<ProductRecentUse> productRecentUses) {
        productRecentUseMapper.insertBranch(productRecentUses);
    }

    private void saveCollectHistory(String dateTime, String marketName, String historyId, String userId) {
        Map<String, String> map = new HashMap<>();
        map.put("historyId", historyId);
        map.put("marketName", marketName);
        map.put("dateTime", dateTime);
        map.put("userId", userId);
        context.publishEvent(new PriceCollectHistoryCreateEvent(map));
    }

    @Override
    public PriceCollectionReps findCollect(String collectHistoryId) {
        PriceCollectionExample example = new PriceCollectionExample();
        example.createCriteria()
                .andHistoryIdIsEqualsTo(collectHistoryId);
        List<PriceCollection> priceCollections = priceCollectionMapper.selectByExample(example);

        List<PriceCollectionRep> priceCollectionReps = new ArrayList<>();
        priceCollections.forEach(priceCollection -> {
            Product product = productMapper.selectNameAndUnitById(priceCollection.getProductId());
            PriceCollectionRep priceCollectionRep = new PriceCollectionRep(priceCollection,
                    product.getName(),
                    product.getUnit());
            priceCollectionReps.add(priceCollectionRep);
        });
        return new PriceCollectionReps(priceCollectionReps);
    }

    @Override
    public void updateCollect(PriceCollectionReps priceCollectionReps) {
        priceCollectionReps.getList().forEach(priceCollectionRep -> {
            PriceCollection priceCollection = new PriceCollection();
            priceCollection.setPrice(priceCollectionRep.getPrice());

            PriceCollectionExample example = new PriceCollectionExample();
            example.createCriteria().andIdEqualTo(priceCollectionRep.getPriceCollectId());
            priceCollectionMapper.updateByExample(priceCollection, example);
        });
    }
}
