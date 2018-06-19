package com.hywa.pricepublish.service;

import com.hywa.pricepublish.representation.PriceCollectionRep;
import com.hywa.pricepublish.representation.ProductRep;

import java.util.Date;
import java.util.List;

public interface PriceCollectionService {
    void save(String userId, String dateTime, String marketId, String marketName, List<ProductRep> reps);

    PriceCollectionRep findCollect(String priceCollectId);
}
