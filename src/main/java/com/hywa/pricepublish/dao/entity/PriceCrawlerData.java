package com.hywa.pricepublish.dao.entity;

public class PriceCrawlerData {
    private Long id;

    private String name;

    private String price;

    private String priceUnit;

    private String maket;

    private String region;

    private String updateTime;

    private String specification;

    private String dataOrigion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit == null ? null : priceUnit.trim();
    }

    public String getMaket() {
        return maket;
    }

    public void setMaket(String maket) {
        this.maket = maket == null ? null : maket.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public String getDataOrigion() {
        return dataOrigion;
    }

    public void setDataOrigion(String dataOrigion) {
        this.dataOrigion = dataOrigion == null ? null : dataOrigion.trim();
    }
}