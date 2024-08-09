package com.vn.dev.core_be.dto.ddnhanvien;

import com.vn.dev.core_be.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DDNhanVienSearchEntity {
    private String keyword;

    private String team;

    private String phone;
    private Gender gender;

    private Date birdDateFrom;

    private Date birdDateTo;
}
