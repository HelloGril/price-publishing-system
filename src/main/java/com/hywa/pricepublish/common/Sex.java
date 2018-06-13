package com.hywa.pricepublish.common;

import com.hywa.pricepublish.common.exception.SexInputException;

public enum Sex {
    MEN("男", (short) 1), WOMEN("女", (short) 2);

    private String sex;
    private Short index;

    Sex(String sex, Short index) {
        this.setSex(sex);
        this.setIndex(index);
    }

    public String getSex() {
        return sex;
    }

    public static String getSex(Short index) {
            if (index == MEN.index) {
                return MEN.getSex();
            } else if (index == WOMEN.index) {
                return WOMEN.getSex();
            } else {
                return null;
            }
    }

    public static short getIndex(String sex) throws SexInputException {
        if (sex.trim().equals(MEN.sex)) {
            return MEN.getIndex();
        } else if (sex.trim().equals(WOMEN.sex)) {
            return WOMEN.getIndex();
        } else {
            throw new SexInputException("性别输入异常，性别只能为：男、女！");
        }
    }

    public Short getIndex() {
        return index;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setIndex(Short index) {
        this.index = index;
    }
}
