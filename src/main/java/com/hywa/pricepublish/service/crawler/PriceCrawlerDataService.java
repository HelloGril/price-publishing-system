package com.hywa.pricepublish.service.crawler;

import com.hywa.pricepublish.dao.entity.PriceCrawlerData;

import java.util.List;

public interface PriceCrawlerDataService {
    List<PriceCrawlerData> findList(String productName, String marketName);

    List<PriceCrawlerData> findALL();
}
