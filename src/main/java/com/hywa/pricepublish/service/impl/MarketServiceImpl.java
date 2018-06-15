package com.hywa.pricepublish.service.impl;

import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.common.UUIDUtils;
import com.hywa.pricepublish.dao.entity.Market;
import com.hywa.pricepublish.dao.entity.MarketExample;
import com.hywa.pricepublish.dao.mapper.MarketMapper;
import com.hywa.pricepublish.representation.MarketRep;
import com.hywa.pricepublish.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MarketServiceImpl implements MarketService {

    @Autowired
    private MarketMapper marketMapper;

    @Override
    public List<MarketRep> findMarkets(String marketTypeCode, String regionId) {
        MarketExample example = new MarketExample();
        example.createCriteria()
                .andRegionIdEqualTo(regionId)
                .andTypeEqualTo(Short.valueOf(marketTypeCode))
                .andIsDelEqualTo(ConstantPool.NOT_DEL);
        List<Market> markets = marketMapper.selectByExample(example);

        List<MarketRep> marketReps = new ArrayList<>();
        markets.forEach(market -> {
            MarketRep marketRep = new MarketRep(market);
            marketReps.add(marketRep);
        });
        return marketReps;
    }

    @Override
    public void save(MarketRep marketRep, String userId) {
        Market market = new Market();
        market.setCreateTime(new Date());
        market.setIsDel(ConstantPool.NOT_DEL);
        market.setCreateUser(userId);
        market.setCreateTime(new Date());
        market.setName(marketRep.getMarketName());
        market.setUpdateTime(new Date());
        market.setRegionId(marketRep.getRegionId());
        market.setId(UUIDUtils.randomUUID());
        market.setType(marketRep.getMarketType());
        market.setRegionType(marketRep.getRegionType());
        marketMapper.insert(market);
    }
}
