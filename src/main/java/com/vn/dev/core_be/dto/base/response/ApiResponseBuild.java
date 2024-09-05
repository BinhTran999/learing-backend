package com.vn.dev.core_be.dto.base.response;

import com.vn.dev.core_be.dto.base.BasePage;

import static com.vn.dev.core_be.exception.ExceptionCode.*;

public class ApiResponseBuild<T> {

    public ApiObjectBaseResponse<T> successObject(T t){
        return new ApiObjectBaseResponse<>(SUCCESS.getCode(),SUCCESS.getDetail(),t);
    }

    public ApiBaseResponse success() {
        return new ApiBaseResponse(SUCCESS.getCode(),SUCCESS.getDetail());
    }

    public ApiObjectBaseResponse<T> exists() {
        return new ApiObjectBaseResponse<>(USER_EXISTED.getCode(),USER_EXISTED.getDetail());
    }

    public ApiObjectBaseResponse<T> invalidPhone() {
        return new ApiObjectBaseResponse<>(INVALID_PHONE.getCode(),INVALID_PHONE.getDetail());
    }

    public ApiObjectBaseResponse<T> invalidName() {
        return new ApiObjectBaseResponse<>(INVALID_NAME.getCode(),INVALID_NAME.getDetail());
    }

    public ApiObjectBaseResponse<T> invalidBirth() {
        return new ApiObjectBaseResponse<>(INVALID_BIRTH.getCode(),INVALID_BIRTH.getDetail());
    }

    public ApiObjectBaseResponse<T> invalidEmail() {
        return new ApiObjectBaseResponse<>(INVALID_MAIL.getCode(),INVALID_MAIL.getDetail());
    }

    public ApiObjectBaseResponse<T> existsEmail() {
        return new ApiObjectBaseResponse<>(EXISTS_MAIL.getCode(),EXISTS_MAIL.getDetail());
    }

    public ApiObjectBaseResponse<BasePage<T>> successObject(BasePage<T> t) {
        return new ApiObjectBaseResponse<>(SUCCESS.getCode(), SUCCESS.getDetail(), t);
    }
}
