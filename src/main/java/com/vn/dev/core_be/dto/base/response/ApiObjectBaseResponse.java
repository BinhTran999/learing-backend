package com.vn.dev.core_be.dto.base.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.vn.dev.core_be.dto.base.BaseDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiObjectBaseResponse<T> extends ApiBaseResponse {

    private T a;

    public ApiObjectBaseResponse(String code, String message, T t){
        super(code, message);
        this.a = t;
    }

}
