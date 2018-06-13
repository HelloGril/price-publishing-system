package com.hywa.pricepublish.service.impl;

import com.hywa.pricepublish.dao.entity.Market;
import com.hywa.pricepublish.service.MarketService;

import java.util.List;

public class MarketServiceImpl implements MarketService {
    @Override
    public List<Market> findMarkets(String marketTypeId, String region) {
        //TODO mapper.xml 未实现
        return null;
    }
}
