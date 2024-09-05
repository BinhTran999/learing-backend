package com.vn.dev.core_be.dto.base.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@With
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PagingRequest<T> extends ApiBaseRequest {
    private T reqPage;

    public PagingRequest(T t){
        this.reqPage = t;
    }

}
