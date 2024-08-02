package com.vn.dev.core_be.mapper;

import com.vn.dev.core_be.dto.ddnhanvien.request.DDNhanVienCreate;
import com.vn.dev.core_be.dto.ddnhanvien.request.DDNhanVienUpdate;
import com.vn.dev.core_be.entity.DDNhanVien;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DDNhanVienMapper {

    DDNhanVien changeToEntity(DDNhanVienCreate data);

    DDNhanVien changeDataUpdateToEntity(DDNhanVienUpdate data);
}
