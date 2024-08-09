package com.vn.dev.core_be.exception;

public class NotFoundException extends MasterException {
    public NotFoundException(String m){
        super(ExceptionCode.NOT_FOUND, m + 22);
    }
}
