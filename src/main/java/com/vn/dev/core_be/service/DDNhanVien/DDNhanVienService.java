package com.vn.dev.core_be.service.DDNhanVien;

import com.vn.dev.core_be.dto.ddnhanvien.request.DDNhanVienCreate;
import com.vn.dev.core_be.dto.ddnhanvien.request.DDNhanVienSearchEntity;
import com.vn.dev.core_be.dto.ddnhanvien.request.DDNhanVienUpdate;
import com.vn.dev.core_be.dto.ddnhanvien.response.DDObjectBaseResponse;
import com.vn.dev.core_be.entity.DDNhanVien;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface DDNhanVienService {

    DDNhanVien getNhanVienByID(UUID id);

    Page<DDNhanVien> getAll();

    Page<DDNhanVien> search(DDNhanVienSearchEntity searchData);

    DDObjectBaseResponse update(UUID id, DDNhanVienUpdate dataUpdate);

    void delete(UUID id);

    DDObjectBaseResponse create(DDNhanVienCreate dataCreate);


}
