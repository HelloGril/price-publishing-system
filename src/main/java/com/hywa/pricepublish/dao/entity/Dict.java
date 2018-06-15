package com.hywa.pricepublish.dao.entity;

public class Dict {
    private String id;

    private String name;

    private String code;

    private String dicttypeid;

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

    public String getDicttypeid() {
        return dicttypeid;
    }

    public void setDicttypeid(String dicttypeid) {
        this.dicttypeid = dicttypeid == null ? null : dicttypeid.trim();
    }
}