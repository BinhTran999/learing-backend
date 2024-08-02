package com.vn.dev.core_be.mapper;

import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienCreate;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienUpdate;
import com.vn.dev.core_be.entity.DDNhanVien;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;
@Component
@Mapper (componentModel = "spring")

public class DDNhanVienMapperImpl implements DDNhanVienMapper {

    public DDNhanVien changeToEntity(DDNhanVienCreate data) {
        return getDdNhanVien(data.getName(), data.getGender(), data.getPhone(), data.getBirth(), data.getEmail(), data.getAddress(), data.getTeam(), data.isStatus());
    }

    private DDNhanVien getDdNhanVien(String name, int gender, String phone, Date birth, String email, String address, String team, boolean status) {
        DDNhanVien entity = new DDNhanVien();
        entity.setId(UUID.randomUUID());
        entity.setName(name);
        entity.setGender(gender);
        entity.setPhone(phone);
        entity.setBirth(birth);
        entity.setEmail(email);
        entity.setAddress(address);
        entity.setTeam(team);
        entity.setStatus(status);
        return entity;
    }

    @Override
    public DDNhanVien changeDataUpdateToEntity(DDNhanVienUpdate data) {
        return getDdNhanVien(data.getName(), data.getGender(), data.getPhone(), data.getBirth(), data.getEmail(), data.getAddress(), data.getTeam(), data.isStatus());
    }


}
