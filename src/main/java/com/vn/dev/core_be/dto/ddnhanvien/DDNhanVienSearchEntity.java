package com.vn.dev.core_be.dto.ddnhanvien;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vn.dev.core_be.dto.base.BaseDto;
import com.vn.dev.core_be.enums.Gender;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DDNhanVienSearchEntity extends BaseDto {
    private int page;
    private String keyword;

    private String team;

    private String phone;
    private String gender;

    @JsonFormat(pattern = "yyyyMMdd")
    private Date birdDateFrom;

    @JsonFormat(pattern = "yyyyMMdd")
    private Date birdDateTo;
}
