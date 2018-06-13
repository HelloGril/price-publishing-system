package com.hywa.pricepublish.common.exception;

public class EncryptionOperationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EncryptionOperationException(String errorMessage) {
        super(errorMessage);
    }
}
