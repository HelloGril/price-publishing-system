package com.hywa.pricepublish.service.crawler.impl;

import com.hywa.pricepublish.dao.entity.PriceCrawlerData;
import com.hywa.pricepublish.dao.entity.PriceCrawlerDataExample;
import com.hywa.pricepublish.dao.mapper.PriceCrawlerDataMapper;
import com.hywa.pricepublish.service.crawler.PriceCrawlerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCrawlerDataServiceImpl implements PriceCrawlerDataService {

    @Autowired
    private PriceCrawlerDataMapper priceCrawlerDataMapper;

    @Override
    public List<PriceCrawlerData> findList(String productName, String marketName) {
        List<PriceCrawlerData> priceCrawlerData = priceCrawlerDataMapper.selectByExample(new PriceCrawlerDataExample());
        return priceCrawlerData;
    }

    @Override
    public List<PriceCrawlerData> findALL() {
        return priceCrawlerDataMapper.selectByExample(new PriceCrawlerDataExample());
    }
}
