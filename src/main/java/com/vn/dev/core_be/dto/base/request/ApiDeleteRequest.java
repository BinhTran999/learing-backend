package com.vn.dev.core_be.dto.base.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiDeleteRequest<T> extends ApiBaseRequest {

    private T delData;

    public ApiDeleteRequest(T t){
        this.delData = t;
    }
}
