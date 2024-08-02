package com.vn.dev.core_be.exception;

public class ExistedException extends MasterException {
    public ExistedException(String m){
        super(ExceptionCode.CODE_EXISTED, m);
    }
}
