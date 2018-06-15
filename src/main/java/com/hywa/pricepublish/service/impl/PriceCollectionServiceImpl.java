package com.hywa.pricepublish.service.impl;

import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.common.UUIDUtils;
import com.hywa.pricepublish.dao.entity.CollectionHistory;
import com.hywa.pricepublish.dao.entity.CollectionHistoryExample;
import com.hywa.pricepublish.dao.entity.PriceCollection;
import com.hywa.pricepublish.dao.mapper.CollectionHistoryMapper;
import com.hywa.pricepublish.dao.mapper.PriceCollectionMapper;
import com.hywa.pricepublish.representation.CollectionHistoryRep;
import com.hywa.pricepublish.representation.ProductRep;
import com.hywa.pricepublish.service.PriceCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PriceCollectionServiceImpl implements PriceCollectionService {
    @Autowired
    private PriceCollectionMapper priceCollectionMapper;

    @Autowired
    private CollectionHistoryMapper collectionHistoryMapper;

    @Transactional
    @Override
    public void save(String userId, Date dateTime, String marketId, String marketName, List<ProductRep> reps) {
        List<PriceCollection> priceCollections = new ArrayList<>();
        reps.forEach(productRep -> {
            PriceCollection priceCollection = new PriceCollection();
            priceCollection.setCreateTime(dateTime);
            priceCollection.setCreateUser(userId);
            priceCollection.setId(UUIDUtils.randomUUID());
            priceCollection.setMarketId(marketId);
            priceCollection.setUpdateTime(dateTime);
            priceCollection.setProcudtId(productRep.getProductId());
            priceCollection.setPrice(productRep.getPrice());
        });
        priceCollectionMapper.insertBatch(priceCollections);

        CollectionHistory collectionHistory = new CollectionHistory();
        collectionHistory.setCollectionTime(dateTime);
        collectionHistory.setId(UUIDUtils.randomUUID());
        collectionHistory.setIsDel(ConstantPool.NOT_DEL);
        collectionHistory.setMarketName(marketName);
        collectionHistoryMapper.insert(collectionHistory);
    }

    @Override
    public List<CollectionHistoryRep> collectHistory(String userId) {
        CollectionHistoryExample example = new CollectionHistoryExample();
        example.createCriteria()
                .andUserIdEqualTo(userId)
                .andIsDelEqualTo(ConstantPool.NOT_DEL);
        List<CollectionHistory> collectionHistories = collectionHistoryMapper.selectByExample(example);

        List<CollectionHistoryRep> collectionHistoryReps = new ArrayList<>();
        collectionHistories.forEach(collectionHistory -> {
            CollectionHistoryRep collectionHistoryRep = new CollectionHistoryRep(collectionHistory);
            collectionHistoryReps.add(collectionHistoryRep);
        });
        return collectionHistoryReps;
    }
}
