package com.vn.dev.core_be.dto.ddnhanvien;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vn.dev.core_be.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DDNhanVienResponse extends BaseDto {

    private UUID id;
    private String code;
    private String name;

    private String gender;

    private String phone;

    @JsonFormat(pattern = "yyyy.MM.dd")
    private Date birth;

    private String email;

    private String address;

    private String team;

    private String status;
}
