package com.vn.dev.core_be.dto.ddnhanvien.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.vn.dev.core_be.entity.DDNhanVien;
import com.vn.dev.core_be.exception.ExceptionCode;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DDNhanVienResponse extends DDBaseResponse {

    private DDNhanVien nv;

    public DDNhanVienResponse(ExceptionCode exe, DDNhanVien entity){
        super(exe);
        this.nv = entity;
    }

}
