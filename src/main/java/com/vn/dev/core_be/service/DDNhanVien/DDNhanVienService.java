package com.vn.dev.core_be.service.DDNhanVien;

import com.vn.dev.core_be.dto.ddnhanvien.request.DDNhanVienCreate;
import com.vn.dev.core_be.dto.ddnhanvien.request.DDNhanVienSearchEntity;
import com.vn.dev.core_be.entity.DDNhanVien;
import io.swagger.models.Response;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface DDNhanVienService {

    DDNhanVien getNhanVienByID(UUID id);

    Page<DDNhanVien> getAll();

    Page<DDNhanVien> search(DDNhanVienSearchEntity searchData);

    void update(UUID id, DDNhanVien dataUpdate);

    void delete(UUID id);

    Response create(DDNhanVienCreate dataCreate);


}
