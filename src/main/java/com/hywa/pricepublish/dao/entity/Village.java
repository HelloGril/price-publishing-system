package com.hywa.pricepublish.dao.entity;

public class Village {
    private String id;

    private String name;

    private String code;

    private String twonId;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getTwonId() {
        return twonId;
    }

    public void setTwonId(String twonId) {
        this.twonId = twonId == null ? null : twonId.trim();
    }
}