package com.hywa.pricepublish.common.enums;

import com.hywa.pricepublish.common.exception.SexInputException;

public enum CommonEnum {
    MEN("男", (short) 1), WOMEN("女", (short) 2), SUCCESS("成功", (short) 0), FAILURE("失败", (short) 1);

    private String value;
    private Short index;

    CommonEnum(String sex, Short index) {
        this.setValue(sex);
        this.setIndex(index);
    }

    public String getValue() {
        return value;
    }

    public static String getSex(Short index) {
        if (index == MEN.index) {
            return MEN.getValue();
        } else if (index == WOMEN.index) {
            return WOMEN.getValue();
        } else {
            return null;
        }
    }

    public static short getIndex(String sex) throws SexInputException {
        if (sex.trim().equals(MEN.value)) {
            return MEN.getIndex();
        } else if (sex.trim().equals(WOMEN.value)) {
            return WOMEN.getIndex();
        } else {
            throw new SexInputException("性别输入异常，性别只能为：男、女！");
        }
    }

    public Short getIndex() {
        return index;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setIndex(Short index) {
        this.index = index;
    }
}
