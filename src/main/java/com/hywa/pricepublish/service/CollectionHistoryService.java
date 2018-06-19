package com.hywa.pricepublish.service;

import com.hywa.pricepublish.representation.CollectionHistoryRep;

import java.util.List;

public interface CollectionHistoryService {
    List<CollectionHistoryRep> collectHistory(String userId);

    void save(String marketName, String historyId, String dateTime);
}
