package com.vn.dev.core_be.dto.ddnhanvien.response;

public class ApiResponseBuild {
    public ApiBaseObjectResponse<T> successObject(T t){
        return new ApiBaseObjectResponse<>(SUCCESS.getCode(),SUCCESS.getDetail(),t);
    }

    public ApiBaseResponse success() {
        return new ApiBaseResponse(SUCCESS.getCode(),SUCCESS.getDetail());
    }

    public ApiBaseObjectResponse<BasePage<T>> successObject(BasePage<T> t) {
        return new ApiBaseObjectResponse<>(SUCCESS.getCode(), SUCCESS.getDetail(), t);
    }
}
