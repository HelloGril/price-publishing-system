package com.hywa.pricepublish.service.impl;

import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.common.DateUtils;
import com.hywa.pricepublish.dao.entity.CollectionHistory;
import com.hywa.pricepublish.dao.entity.CollectionHistoryExample;
import com.hywa.pricepublish.dao.mapper.CollectionHistoryMapper;
import com.hywa.pricepublish.representation.CollectionHistoryRep;
import com.hywa.pricepublish.service.CollectionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionHistoryServiceImpl implements CollectionHistoryService {

    @Autowired
    private CollectionHistoryMapper collectionHistoryMapper;


    @Override
    @Transactional
    public void save(String marketName, String historyId, String dateTime) {
        CollectionHistory collectionHistory = new CollectionHistory();
        collectionHistory.setId(historyId);
        collectionHistory.setIsDel(ConstantPool.NOT_DEL);
        collectionHistory.setMarketName(marketName);
        try {
            collectionHistory.setCollectionTime(DateUtils.stringToDate(dateTime, DateUtils.DETAIL));
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
