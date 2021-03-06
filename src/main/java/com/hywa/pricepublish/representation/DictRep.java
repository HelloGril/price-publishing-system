package com.hywa.pricepublish.representation;

import java.util.Objects;

public class DictRep {
    private String id;
    private String code;
    private String name;

    public DictRep() {
    }

    public DictRep(String id, String code, String name) {
        this.setId(id);
        this.setCode(code);
        this.setName(name);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictRep dictRep = (DictRep) o;
        return Objects.equals(id, dictRep.id) &&
                Objects.equals(code, dictRep.code) &&
                Objects.equals(name, dictRep.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, code, name);
    }

    @Override
    public String toString() {
        return "DictRep{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
