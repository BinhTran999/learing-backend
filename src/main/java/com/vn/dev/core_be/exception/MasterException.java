package com.vn.dev.core_be.exception;

import lombok.Getter;

@Getter
public class MasterException extends RuntimeException {
    protected final ExceptionCode exceptionCode;
    protected final String message;


    public MasterException(ExceptionCode exceptionCode, String message) {
        this.exceptionCode = exceptionCode;
        this.message = message;
    }

    @Override
    public String toString() {
        return exceptionCode.getDetail() + ": " + message;
    }
}
