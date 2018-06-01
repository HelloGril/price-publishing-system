package com.hywa.pricepublish.representation;

import java.io.Serializable;

public class ResponseBase<T> implements Serializable {
    private static final long serialVersionUID = -4963266899668807475L;
    private ResponseHead retHead;
    private T retBody;

    public ResponseHead getRetHead() {
        return retHead;
    }

    public void setRetHead(ResponseHead retHead) {
        this.retHead = retHead;
    }

    public void setRetHead(String code, String msg) {
        this.retHead = new ResponseHead(code,msg);
    }

    public T getRetBody() {
        return retBody;
    }

    public void setRetBody(T retBody) {
        this.retBody = retBody;
    }

    @Override
    public String toString() {
        return "ResponseBase{" +
                "retHead=" + retHead +
                ", retBody=" + retBody +
                '}';
    }
}

