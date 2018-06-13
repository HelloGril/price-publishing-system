package com.hywa.pricepublish.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Price_collection {
    private String id;

    private String name;

    private Date createTime;

    private Date updateTime;

    private String createUser;

    private String description;

    private String procudtId;

    private BigDecimal price;

    private Short priceType;

    private String marketId;

    private String productId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getProcudtId() {
        return procudtId;
    }

    public void setProcudtId(String procudtId) {
        this.procudtId = procudtId == null ? null : procudtId.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Short getPriceType() {
        return priceType;
    }

    public void setPriceType(Short priceType) {
        this.priceType = priceType;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId == null ? null : marketId.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }
}