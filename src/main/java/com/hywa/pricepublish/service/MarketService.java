package com.hywa.pricepublish.service;

import com.hywa.pricepublish.dao.entity.Market;

import java.util.List;

public interface MarketService {
    List<Market> findMarkets(String marketTypeId, String region);
}
