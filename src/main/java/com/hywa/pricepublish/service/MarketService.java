package com.hywa.pricepublish.service;

import com.hywa.pricepublish.representation.MarketRep;

import java.util.List;

public interface MarketService {
    List<MarketRep> findMarkets(String marketTypeCode, String region);

    void save(MarketRep marketRep, String userId);
}
