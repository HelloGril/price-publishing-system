package com.hywa.pricepublish.service.collect;

import com.hywa.pricepublish.representation.MarketRecentUseReps;
import com.hywa.pricepublish.representation.MarketRep;
import com.hywa.pricepublish.representation.MarketReps;

import java.util.List;

public interface MarketService {
    MarketReps findMarkets(String marketTypeCode, String region, Integer pageNum, Integer pageSize);

    void save(MarketRep marketRep, String userId);

    public MarketRecentUseReps findMarketRecentUse(String userId);
}
