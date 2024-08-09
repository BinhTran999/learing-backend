package com.vn.dev.core_be.dto.ddnhanvien;


import com.vn.dev.core_be.dto.base.BaseDto;
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
public class DDNhanVienCreate extends BaseDto {
    private String name;

    private String gender;

    private String phone;

    private Date birth;

    private String email;

    private String address;

    private String team;

    private boolean status;
}
