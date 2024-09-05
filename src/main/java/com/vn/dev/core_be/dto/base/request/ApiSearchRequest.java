package com.vn.dev.core_be.dto.base.request;

import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienSearchEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiSearchRequest<T>  extends ApiBaseRequest {

    private T searchData;

    public ApiSearchRequest(T t){
        this.searchData = t;
    }
}
