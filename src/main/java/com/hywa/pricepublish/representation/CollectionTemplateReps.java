package com.hywa.pricepublish.representation;

import java.util.ArrayList;
import java.util.List;

public class CollectionTemplateReps {
    private List<CollectionTemplateRep> list;

    private Integer total;

    public CollectionTemplateReps() {
    }

    public CollectionTemplateReps(List<CollectionTemplateRep> list) {
        this.setList(list);
    }

    public CollectionTemplateReps(List<CollectionTemplateRep> list, Integer total) {
        this(list);
        this.setTotal(total);
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<CollectionTemplateRep> getList() {
        return list;
    }

    public void setList(List<CollectionTemplateRep> list) {
        this.list = new ArrayList<>(list);
    }

}
