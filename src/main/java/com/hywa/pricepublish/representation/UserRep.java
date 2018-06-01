

package com.hywa.pricepublish.representation;

import java.io.Serializable;
import java.util.List;

public class UserRep implements Serializable {
    private static final long serialVersionUID = -4963266899668807475L;
    private String uid;
    private String name;
    private int authority;

    public UserRep() {
    }

    public UserRep(String uid, String name, int authority) {
        this.uid = uid;
        this.name = name;
        this.authority = authority;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "UserRep{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", authority=" + authority +
                '}';
    }
}


