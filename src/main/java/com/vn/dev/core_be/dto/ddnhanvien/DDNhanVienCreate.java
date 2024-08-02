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
public class DDNhanVienCreate {
    private String name;

    private int gender;

    private String phone;

    private Date birth;

    private String email;

    private String address;

    private String team;

    private boolean status;
}