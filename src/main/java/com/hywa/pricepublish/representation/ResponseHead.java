package com.hywa.pricepublish.representation;

import java.io.Serializable;

public class ResponseHead implements Serializable {
    private static final long serialVersionUID = -4963266899668807475L;
    private String errCode;
    private String errMsg;

    public ResponseHead() {
    }

    public ResponseHead(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "ResponseHead{" +
                "errCode='" + errCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}

