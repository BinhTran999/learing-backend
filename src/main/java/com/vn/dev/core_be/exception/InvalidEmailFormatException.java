package com.vn.dev.core_be.exception;

public class InvalidEmailFormatException extends MasterException {
    public InvalidEmailFormatException(String message) {
        super( ExceptionCode.EMAIL_INVALID, message);
    }
}
