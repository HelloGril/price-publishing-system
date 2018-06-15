package com.hywa.pricepublish.representation;

import com.hywa.pricepublish.dao.entity.CollectionHistory;

import java.util.Date;
import java.util.Objects;

public class CollectionHistoryRep {
    private Date collectTime;
    private String priceCollectId;
    private String marketName;

    public CollectionHistoryRep() {
    }

    public CollectionHistoryRep(CollectionHistory collectionHistory) {
        this.setCollectTime(collectionHistory.getCollectionTime());
        this.setPriceCollectId(collectionHistory.getPriceCollectId());
        this.setMarketName(collectionHistory.getMarketName());
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    public String getPriceCollectId() {
        return priceCollectId;
    }

    public void setPriceCollectId(String priceCollectId) {
        this.priceCollectId = priceCollectId;
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
                Objects.equals(priceCollectId, that.priceCollectId) &&
                Objects.equals(marketName, that.marketName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(collectTime, priceCollectId, marketName);
    }

    @Override
    public String toString() {
        return "CollectionHistoryRep{" +
                "collectTime='" + collectTime + '\'' +
                ", priceCollectId='" + priceCollectId + '\'' +
                ", marketName='" + marketName + '\'' +
                '}';
    }
}
