package com.vn.dev.core_be.dto.base.response;

import com.vn.dev.core_be.dto.base.BaseDto;
import com.vn.dev.core_be.dto.base.BasePage;

import static com.vn.dev.core_be.exception.ExceptionCode.SUCCESS;

public class ApiResponseBuild<T> {

    public ApiObjectBaseResponse<T> successObject(T t){
        return new ApiObjectBaseResponse<>(SUCCESS.getCode(),SUCCESS.getDetail(),t);
    }

    public ApiBaseResponse success() {
        return new ApiBaseResponse(SUCCESS.getCode(),SUCCESS.getDetail());
    }

    public ApiObjectBaseResponse<BasePage<T>> successObject(BasePage<T> t) {
        return new ApiObjectBaseResponse<>(SUCCESS.getCode(), SUCCESS.getDetail(), t);
    }
}
