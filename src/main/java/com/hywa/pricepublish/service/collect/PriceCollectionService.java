package com.hywa.pricepublish.service.collect;

import com.hywa.pricepublish.representation.PriceCollectionReps;
import com.hywa.pricepublish.representation.ProductRep;

import java.util.List;

public interface PriceCollectionService {
    void save(String userId, String dateTime, String marketId, String marketName, List<ProductRep> reps);

    PriceCollectionReps findCollect(String priceCollectId);

    void updateCollect(PriceCollectionReps priceCollectionReps);
}
