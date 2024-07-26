package com.vn.dev.core_be.dto.ddnhanvien;

import com.vn.dev.core_be.entity.DDNhanVien;

import java.util.List;

public class BasePage {
    protected  Integer page;
    protected Integer totalPage;

    protected Long totalRecord;
    protected List<DDNhanVien> data;
}
