package com.vn.dev.core_be.service.DDNhanVien;

import com.vn.dev.core_be.dto.base.BasePage;
import com.vn.dev.core_be.dto.base.response.ApiBaseResponse;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienCreate;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienSearchEntity;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienUpdate;
import com.vn.dev.core_be.dto.base.response.ApiObjectBaseResponse;
import com.vn.dev.core_be.entity.DDNhanVien;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface DDNhanVienService {

    ApiObjectBaseResponse<DDNhanVien> getNhanVienByID(UUID id);

    BasePage<DDNhanVien> getAll();

    BasePage<DDNhanVien> search(DDNhanVienSearchEntity searchData);

    ApiObjectBaseResponse<DDNhanVien> update(UUID id, DDNhanVienUpdate dataUpdate);

    ApiBaseResponse delete(UUID id);

    ApiObjectBaseResponse<DDNhanVien> create(DDNhanVienCreate dataCreate);


}
