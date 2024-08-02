package com.vn.dev.core_be.dto.ddnhanvien.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.vn.dev.core_be.dto.ddnhanvien.BaseDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DDObjectBaseResponse<T extends BaseDto> extends DDBaseResponse {

    private T a;

    public DDObjectBaseResponse(String code, String message, T t){
        super(code, message);
        this.a = t;
    }

}
