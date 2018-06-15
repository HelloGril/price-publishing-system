package com.hywa.pricepublish.dao.entity;

public class UserAreaKey {
    private String userId;

    private String regionId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getregionId() {
        return regionId;
    }

    public void setregionId(String regionId) {
        this.regionId = regionId == null ? null : regionId.trim();
    }
}