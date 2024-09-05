package com.vn.dev.core_be.dto.base.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiRequest<T>  extends ApiBaseRequest {

    private T data;

    public ApiRequest(T t){
        this.data = t;
    }
}