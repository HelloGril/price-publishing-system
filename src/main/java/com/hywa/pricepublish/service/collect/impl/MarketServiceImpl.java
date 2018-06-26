package com.hywa.pricepublish.service.collect.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.common.utils.UUIDUtils;
import com.hywa.pricepublish.dao.entity.Market;
import com.hywa.pricepublish.dao.entity.MarketExample;
import com.hywa.pricepublish.dao.entity.MarketRecentUse;
import com.hywa.pricepublish.dao.entity.MarketRecentUseExample;
import com.hywa.pricepublish.dao.mapper.MarketMapper;
import com.hywa.pricepublish.dao.mapper.MarketRecentUseMapper;
import com.hywa.pricepublish.representation.MarketRecentUseRep;
import com.hywa.pricepublish.representation.MarketRecentUseReps;
import com.hywa.pricepublish.representation.MarketRep;
import com.hywa.pricepublish.representation.MarketReps;
import com.hywa.pricepublish.service.collect.MarketService;
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

    @Autowired
    private MarketRecentUseMapper marketRecentUseMapper;

    @Override
    public MarketReps findMarkets(String marketTypeId, String regionId, Integer pageNum, Integer pageSize) {
        MarketExample example = new MarketExample();
        example.createCriteria()
                .andRegionIdEqualTo(regionId)
                .andMarketTypeEqualTo(marketTypeId)
                .andIsDelEqualTo(ConstantPool.NOT_DEL);

        PageHelper.startPage(pageNum, pageSize, true);
        List<Market> markets = marketMapper.selectByExample(example);
        PageInfo<Market> pageInfo = new PageInfo<>(markets);

        List<MarketRep> marketReps = new ArrayList<>();
        markets.forEach(market -> {
            MarketRep marketRep = new MarketRep(market);
            marketReps.add(marketRep);
        });
        return new MarketReps(marketReps, pageInfo.getTotal());
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
        market.setMarketType(marketRep.getMarketType());
        market.setRegionType(marketRep.getRegionType());
        marketMapper.insert(market);
    }

    @Override
    public MarketRecentUseReps findMarketRecentUse(String userId) {
        List<MarketRecentUseRep> marketRecentUseReps = new ArrayList<>();
        MarketRecentUseExample example = new MarketRecentUseExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<MarketRecentUse> marketRecentUses = marketRecentUseMapper.selectByExample(example);
        marketRecentUses.forEach(marketRecentUse -> {
            String marketId = marketRecentUse.getMarketId();
            String marketName = marketMapper.selectNameById(marketId);
            marketRecentUseReps.add(new MarketRecentUseRep(marketId, marketName));
        });
        return new MarketRecentUseReps(marketRecentUseReps);
    }
}
