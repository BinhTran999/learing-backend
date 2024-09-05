package com.vn.dev.core_be.exception;

public class PageNotExistedException extends MasterException {
    public PageNotExistedException(String m) {
        super(ExceptionCode.FORBIDDEN, m);
    }
}