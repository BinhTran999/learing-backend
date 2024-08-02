package com.vn.dev.core_be.dto.ddnhanvien.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.Date;
import java.util.UUID;

public class DDNhanVienEdit {


    private String name;

    private String code;

    private int gender;

    private String phone;

    private Date birth;

    private String email;

    private String address;

    private String team;

    private boolean status;

    private int order;
}
