package com.vn.dev.core_be.service.DDNhanVien;

import com.vn.dev.core_be.dto.base.BasePage;
import com.vn.dev.core_be.dto.base.response.ApiBaseResponse;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienCreate;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienResponse;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienSearchEntity;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienUpdate;
import com.vn.dev.core_be.dto.base.response.ApiObjectBaseResponse;
import com.vn.dev.core_be.entity.DDNhanVien;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
public interface DDNhanVienService {

    ApiObjectBaseResponse<DDNhanVienResponse> getNhanVienByID(UUID id);

    BasePage<DDNhanVienResponse> getAll();

    BasePage<DDNhanVienResponse> getAllPage(int page);

    BasePage<DDNhanVienResponse> search(DDNhanVienSearchEntity searchData);

    ApiObjectBaseResponse<DDNhanVien> update(DDNhanVienUpdate dataUpdate);

    ApiBaseResponse delete(UUID id);

    ApiBaseResponse create(DDNhanVienCreate dataCreate);


}
