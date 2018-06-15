package com.hywa.pricepublish.service;

import com.hywa.pricepublish.representation.CollectionHistoryRep;
import com.hywa.pricepublish.representation.ProductRep;

import java.util.Date;
import java.util.List;

public interface PriceCollectionService {
    void save(String userId, Date dateTime, String marketId, String marketName, List<ProductRep> reps);

    List<CollectionHistoryRep> collectHistory(String userId);
}
