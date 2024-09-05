package com.vn.dev.core_be.mapper.DDNhanVien;

import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienCreate;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienResponse;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienUpdate;
import com.vn.dev.core_be.entity.DDNhanVien;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface DDNhanVienMapper {

    DDNhanVien changeToEntity(DDNhanVienCreate data);

    DDNhanVien changeDataUpdateToEntity(UUID id, DDNhanVienUpdate data);


}
