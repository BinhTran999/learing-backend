package com.vn.dev.core_be.mapper.DDNhanVien;

import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienCreate;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienUpdate;
import com.vn.dev.core_be.entity.DDNhanVien;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface DDNhanVienMapper {

    DDNhanVien changeToEntity(DDNhanVienCreate data);

    DDNhanVien changeDataUpdateToEntity(UUID id, DDNhanVienUpdate data);

}
