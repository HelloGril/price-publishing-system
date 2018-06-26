package com.hywa.pricepublish.representation;

import com.hywa.pricepublish.common.utils.DateUtils;
import com.hywa.pricepublish.dao.entity.CollectionHistory;

import java.util.Objects;

public class CollectionHistoryRep {
    private String collectTime;
    private String collectHistoryId;
    private String marketName;

    public CollectionHistoryRep() {
    }

    public CollectionHistoryRep(CollectionHistory collectionHistory) {
        this.setCollectTime(DateUtils.formatDate(collectionHistory.getCollectionTime(), DateUtils.DEFAULT_FORMAT));
        this.setCollectHistoryId(collectionHistory.getId());
        this.setMarketName(collectionHistory.getMarketName());
    }

    public String getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(String collectTime) {
        this.collectTime = collectTime;
    }

    public String getCollectHistoryId() {
        return collectHistoryId;
    }

    public void setCollectHistoryId(String collectHistoryId) {
        this.collectHistoryId = collectHistoryId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionHistoryRep that = (CollectionHistoryRep) o;
        return Objects.equals(collectTime, that.collectTime) &&
                Objects.equals(collectHistoryId, that.collectHistoryId) &&
                Objects.equals(marketName, that.marketName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(collectTime, collectHistoryId, marketName);
    }

    @Override
    public String toString() {
        return "CollectionHistoryRep{" +
                "collectTime='" + collectTime + '\'' +
                ", collectHistoryId='" + collectHistoryId + '\'' +
                ", marketName='" + marketName + '\'' +
                '}';
    }
}
