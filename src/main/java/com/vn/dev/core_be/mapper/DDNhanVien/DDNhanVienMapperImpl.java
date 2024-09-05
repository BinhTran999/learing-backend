package com.vn.dev.core_be.mapper.DDNhanVien;

import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienCreate;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienResponse;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienUpdate;
import com.vn.dev.core_be.entity.DDNhanVien;
import com.vn.dev.core_be.enums.Gender;
import com.vn.dev.core_be.repository.DDNhanVienRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Component
@Mapper (componentModel = "spring")
@AllArgsConstructor
public class DDNhanVienMapperImpl implements DDNhanVienMapper {

    private DDNhanVienRepository repository;
    public DDNhanVien changeToEntity(DDNhanVienCreate data) {
        DDNhanVien entity = new DDNhanVien();
        entity.setId(UUID.randomUUID());
        entity.setName(data.getName());
        // code
        DDNhanVien d = repository.findTopByOrderByIdDesc();
        if (d == null){
            entity.setCode("63200000");
        } else {
            entity.setCode(Integer.toString(Integer.parseInt(d.getCode()) + 1));
        }
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
        String s = repository.getCodeForID(id);
        entity.setCode(s.substring(s.length() - 8));
        entity.setBirth(data.getBirth());
        entity.setEmail(data.getEmail());
        entity.setAddress(data.getAddress());
        entity.setTeam(data.getTeam());
        entity.setStatus(data.getStatus());
        return entity;
    }

    @Mapping(source = "code", target = "code")
    public List<DDNhanVienResponse> changeToListResponseEntity(List<DDNhanVien> lisEntity) {
        List<DDNhanVienResponse> listRes = new ArrayList<>();
        for (DDNhanVien res : lisEntity){
            DDNhanVienResponse e = new DDNhanVienResponse();
            e.setId(res.getId());
            e.setName(res.getName());
            e.setGender(res.getGender());
            e.setPhone(res.getPhone());
            e.setCode(res.getCode());
            e.setBirth(res.getBirth());
            e.setEmail(res.getEmail());
            e.setAddress(res.getAddress());
            e.setTeam(res.getTeam());
            e.setStatus(res.getStatus()? "active" : "inactive");
            listRes.add(e);
        }
        return listRes;
    }

    @Mapping(source = "code", target = "code")
    public DDNhanVienResponse changeToResponseEntity(DDNhanVien lisEntity) {
            DDNhanVienResponse e = new DDNhanVienResponse();
            e.setId(lisEntity.getId());
            e.setName(lisEntity.getName());
            e.setGender(lisEntity.getGender());
            e.setPhone(lisEntity.getPhone());
            e.setCode(lisEntity.getCode());
            e.setBirth(lisEntity.getBirth());
            e.setEmail(lisEntity.getEmail());
            e.setAddress(lisEntity.getAddress());
            e.setTeam(lisEntity.getTeam());
            e.setStatus(lisEntity.getStatus()? "active" : "inactive");

        return e;
    }


}
