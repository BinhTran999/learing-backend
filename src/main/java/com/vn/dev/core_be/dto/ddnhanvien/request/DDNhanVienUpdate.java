package com.vn.dev.core_be.dto.ddnhanvien.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DDNhanVienUpdate {
    private String name;

    private int gender;

    private String phone;

    private Date birth;

    private String email;

    private String address;

    private String team;

    private boolean status;

    private int order;
}
