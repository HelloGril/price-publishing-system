package com.hywa.pricepublish.representation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DictReps {
    List<DictRep> list;

    public DictReps(List<DictRep> dictList) {
        this.setList(dictList);
    }

    public List<DictRep> getList() {
        return list;
    }

    public void setList(List<DictRep> list) {
        list = new ArrayList<>(list);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictReps dictReps = (DictReps) o;
        return Objects.equals(list, dictReps.list);
    }

    @Override
    public int hashCode() {

        return Objects.hash(list);
    }

    @Override
    public String toString() {
        return "DictReps{" +
                "list=" + list +
                '}';
    }
}
