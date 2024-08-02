package com.vn.dev.core_be.dto.ddnhanvien.response;

import com.vn.dev.core_be.dto.ddnhanvien.BaseDto;
import com.vn.dev.core_be.dto.ddnhanvien.BasePage;

import static com.vn.dev.core_be.exception.ExceptionCode.SUCCESS;

public class ApiResponseBuild<T extends BaseDto> {
    public DDObjectBaseResponse<T> successObject(T t){
        return new DDObjectBaseResponse(SUCCESS.getCode(),SUCCESS.getDetail(),t);
    }

    public DDBaseResponse success() {
        return new DDBaseResponse(SUCCESS.getCode(),SUCCESS.getDetail());
    }

    public DDObjectBaseResponse<BasePage<T>> successObject(BasePage<T> t) {
        return new DDObjectBaseResponse(SUCCESS.getCode(), SUCCESS.getDetail(), t);
    }
}
