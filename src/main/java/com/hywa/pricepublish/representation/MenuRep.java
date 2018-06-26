package com.hywa.pricepublish.representation;

import com.hywa.pricepublish.dao.entity.Menu;

public class MenuRep extends Menu {

    private String name;

    private String description;

    private String icon;

    private short status;

    private String parentId;

    private short type;

    public MenuRep(Menu menu){
        setDescription(menu.getDescription());
        setIcon(menu.getIcon());
        setName(menu.getName());
        setParentId(menu.getParentId());
        setStatus(menu.getStatus());
        setType(menu.getType());
    }
    public MenuRep(){ }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
