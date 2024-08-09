package com.vn.dev.core_be.service.DDNhanVien;

import com.vn.dev.core_be.dto.base.BasePage;
import com.vn.dev.core_be.dto.base.request.ApiListBaseRequest;
import com.vn.dev.core_be.dto.base.response.ApiBaseResponse;
import com.vn.dev.core_be.dto.base.response.ApiObjectBaseResponse;
import com.vn.dev.core_be.dto.base.response.ApiResponseBuild;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienCreate;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienSearchEntity;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienUpdate;
import com.vn.dev.core_be.entity.DDNhanVien;
import com.vn.dev.core_be.exception.ExceptionCode;
import com.vn.dev.core_be.exception.ExistedException;
import com.vn.dev.core_be.exception.NotFoundException;
import com.vn.dev.core_be.mapper.DDNhanVien.DDNhanVienMapperImpl;
import com.vn.dev.core_be.repository.DDNhanVienRepository;
import com.vn.dev.core_be.utils.Paging;
import com.vn.dev.core_be.utils.Search;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DDNhanVienServiceImpl implements DDNhanVienService {

    private DDNhanVienMapperImpl DDNhanVienMapper;

    private DDNhanVienRepository repository;

    @Override
    public ApiObjectBaseResponse<DDNhanVien> getNhanVienByID(UUID id) {
        System.out.println(999);
        if (!repository.getExistsEntityById(id)){
            throw new NotFoundException("Mã nhân viên" + id + " chưa tồn tại");
        }
        return new ApiObjectBaseResponse<>(ExceptionCode.SUCCESS.getCode(), ExceptionCode.SUCCESS.getDetail(), repository.getEntityById(id));
    }

    @Override
    @Transactional
    public BasePage<DDNhanVien> getAll() {
        ApiListBaseRequest req = new ApiListBaseRequest();
        List<DDNhanVien> data = repository.findAll(Paging.buildPageRequest(req)).getContent();
        return new BasePage<>(req.getPage(), req.getSize(), (long) data.size(), data);
    }

    @Override
    @Transactional
    public BasePage<DDNhanVien> search(DDNhanVienSearchEntity searchData) {
        ApiListBaseRequest req = new ApiListBaseRequest();
        List<DDNhanVien> data = repository.searchingElement(searchData.getKeyword(), searchData.getTeam(), searchData.getPhone(), Search.getGender(searchData.getGender()), searchData.getBirdDateFrom(), searchData.getBirdDateTo());
        return new BasePage<>(req.getPage(), req.getSize(), (long) data.size(), data);
    }

    @Override
    @Transactional
    public ApiObjectBaseResponse<DDNhanVien> update(UUID id, DDNhanVienUpdate dataUpdate) {
        if (!repository.getExistsEntityById(id)){
            throw new NotFoundException("Mã nhân viên" + id + " chưa tồn tại");
        }
        DDNhanVien entity = repository.save(DDNhanVienMapper.changeDataUpdateToEntity(id, dataUpdate));
        return new ApiObjectBaseResponse<>(ExceptionCode.SUCCESS.getCode(), ExceptionCode.SUCCESS.getDetail(), entity);
    }

    @Override
    @Transactional
    public ApiBaseResponse delete(UUID id) {
        if (!repository.getExistsEntityById(id)){
            throw new NotFoundException("Mã nhân viên" + id + " chưa tồn tại");
        }
        repository.delete(repository.getEntityById(id));
        return new ApiResponseBuild<>().success();
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "CacheConfig")
    public ApiObjectBaseResponse<DDNhanVien> create(DDNhanVienCreate dataCreate) {
        if (repository.findEntityByName(dataCreate.getName()) == null){
            throw new ExistedException("Mã nhân viên có tên " + dataCreate.getName() + " chưa tồn tại");
        }
        DDNhanVien entity = repository.save(DDNhanVienMapper.changeToEntity(dataCreate));
        return new ApiObjectBaseResponse<>(ExceptionCode.SUCCESS.getCode(), ExceptionCode.SUCCESS.getDetail(), entity);
    }
}
