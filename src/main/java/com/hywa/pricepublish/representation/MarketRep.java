package com.hywa.pricepublish.representation;

import com.hywa.pricepublish.dao.entity.Market;

import java.util.Objects;

public class MarketRep {
    private String marketId;
    private String marketName;
    private String marketType;
    private String regionId;
    private Short regionType;

    public MarketRep() {
    }

    public MarketRep(Market market) {
        this.setMarketName(market.getName());
        this.setMarketType(market.getMarketType());
        this.setMarketId(market.getId());
    }

    private void setMarketName(String name) {
        this.marketName = name;
    }

    public String getMarketName() {
        return marketName;
    }

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public Short getRegionType() {
        return regionType;
    }

    public void setRegionType(Short regionType) {
        this.regionType = regionType;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketRep marketRep = (MarketRep) o;
        return Objects.equals(marketId, marketRep.marketId) &&
                Objects.equals(marketName, marketRep.marketName) &&
                Objects.equals(marketType, marketRep.marketType) &&
                Objects.equals(regionId, marketRep.regionId) &&
                Objects.equals(regionType, marketRep.regionType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(marketId, marketName, marketType, regionId, regionType);
    }

    @Override
    public String toString() {
        return "MarketRep{" +
                "marketId='" + marketId + '\'' +
                ", marketName='" + marketName + '\'' +
                ", marketType=" + marketType +
                ", regionId='" + regionId + '\'' +
                ", regionType=" + regionType +
                '}';
    }
}
