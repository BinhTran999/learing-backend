package com.vn.dev.core_be.dto.ddnhanvien.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.vn.dev.core_be.entity.DDNhanVien;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DDNhanVienResponse extends DDBaseResponse {

    private DDNhanVien nv;

    public DDNhanVienResponse(String code, String message, DDNhanVien entity){
        super(code, message);
        this.nv = entity;
    }

}
