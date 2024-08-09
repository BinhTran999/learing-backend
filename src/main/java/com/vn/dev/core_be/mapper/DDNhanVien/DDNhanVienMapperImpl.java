package com.vn.dev.core_be.mapper.DDNhanVien;

import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienCreate;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienUpdate;
import com.vn.dev.core_be.entity.DDNhanVien;
import com.vn.dev.core_be.enums.Gender;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;
@Component
@Mapper (componentModel = "spring")

public class DDNhanVienMapperImpl implements DDNhanVienMapper {

    public DDNhanVien changeToEntity(DDNhanVienCreate data) {
        DDNhanVien entity = new DDNhanVien();
        entity.setId(UUID.randomUUID());
        entity.setName(data.getName());
        entity.setGender(data.getGender());
        entity.setPhone(data.getPhone());
        entity.setBirth(data.getBirth());
        entity.setEmail(data.getEmail());
        entity.setAddress(data.getAddress());
        entity.setTeam(data.getTeam());
        return entity;
    }

    @Override
    public DDNhanVien changeDataUpdateToEntity(UUID id, DDNhanVienUpdate data) {
        DDNhanVien entity = new DDNhanVien();
        entity.setId(id);
        entity.setName(data.getName());
        entity.setGender(data.getGender());
        entity.setPhone(data.getPhone());
        entity.setCode(data.getCode());
        entity.setBirth(data.getBirth());
        entity.setEmail(data.getEmail());
        entity.setAddress(data.getAddress());
        entity.setTeam(data.getTeam());
        entity.setStatus(data.getStatus());
        return entity;
    }


}