package com.hywa.pricepublish.common.exception;

public class GlobalException extends RuntimeException{

    public GlobalException(String errorMessage) {
        super(errorMessage);
    }
    public GlobalException(String reason, String errorMessage) {
        super(reason,new GlobalException(errorMessage));
    }

}