package com.hywa.pricepublish.service.impl;

import com.hywa.pricepublish.common.DateUtils;
import com.hywa.pricepublish.common.UUIDUtils;
import com.hywa.pricepublish.dao.entity.PriceCollection;
import com.hywa.pricepublish.dao.entity.PriceCollectionExample;
import com.hywa.pricepublish.dao.mapper.CollectionHistoryMapper;
import com.hywa.pricepublish.dao.mapper.PriceCollectionMapper;
import com.hywa.pricepublish.event.PriceCollectedEvent;
import com.hywa.pricepublish.representation.PriceCollectionRep;
import com.hywa.pricepublish.representation.ProductRep;
import com.hywa.pricepublish.service.PriceCollectionService;
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
    private CollectionHistoryMapper collectionHistoryMapper;

    @Autowired
    private ApplicationContext context;

    @Override
    @Transactional
    public void save(String userId, String dateTime, String marketId, String marketName, List<ProductRep> reps) {
        String historyId = UUIDUtils.randomUUID();
        List<PriceCollection> priceCollections = new ArrayList<>();
        reps.forEach(productRep -> {
            PriceCollection priceCollection = new PriceCollection();
            priceCollection.setCreateUser(userId);
            priceCollection.setId(UUIDUtils.randomUUID());
            priceCollection.setMarketId(marketId);
            priceCollection.setProcudtId(productRep.getProductId());
            priceCollection.setPrice(productRep.getPrice());
            priceCollection.setHistoryId(historyId);
            try {
                priceCollection.setCreateTime(DateUtils.stringToDate(dateTime, DateUtils.DETAIL));
                priceCollection.setUpdateTime(DateUtils.stringToDate(dateTime, DateUtils.DETAIL));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        priceCollectionMapper.insertBatch(priceCollections);
        saveCollectHistory(dateTime, marketName, historyId);
    }

    private void saveCollectHistory(String dateTime, String marketName, String historyId) {
        Map<String, String> map = new HashMap<>();
        map.put("historyId", historyId);
        map.put("marketName", marketName);
        map.put("dateTime", dateTime);
        context.publishEvent(new PriceCollectedEvent(map));
    }

    @Override
    public PriceCollectionRep findCollect(String priceCollectId) {
        //TODO userID,dateTime,
        PriceCollectionExample example = new PriceCollectionExample();
        example.createCriteria()
                .andIdEqualTo(priceCollectId);
        PriceCollection priceCollection = priceCollectionMapper.selectByExample(example).get(0);
        return new PriceCollectionRep(priceCollection);
    }
}
