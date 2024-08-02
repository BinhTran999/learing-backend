package com.vn.dev.core_be.dto.ddnhanvien;

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
    private int gender;

    private Date birdDateFrom;

    private Date birdDateTo;
}
