package com.vn.dev.core_be.service.DDNhanVien;

import com.vn.dev.core_be.dto.base.BasePage;
import com.vn.dev.core_be.dto.base.request.ApiListBaseRequest;
import com.vn.dev.core_be.dto.base.response.ApiBaseResponse;
import com.vn.dev.core_be.dto.base.response.ApiObjectBaseResponse;
import com.vn.dev.core_be.dto.base.response.ApiResponseBuild;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienCreate;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienResponse;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienSearchEntity;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienUpdate;
import com.vn.dev.core_be.entity.DDNhanVien;
import com.vn.dev.core_be.exception.ExceptionCode;
import com.vn.dev.core_be.exception.ExistedException;
import com.vn.dev.core_be.exception.NotFoundException;
import com.vn.dev.core_be.exception.PageNotExistedException;
import com.vn.dev.core_be.mapper.DDNhanVien.DDNhanVienMapperImpl;
import com.vn.dev.core_be.repository.DDNhanVienRepository;
import com.vn.dev.core_be.utils.Paging;
import com.vn.dev.core_be.utils.Search;
import com.vn.dev.core_be.validate.UniteValidation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@AllArgsConstructor
public class DDNhanVienServiceImpl implements DDNhanVienService {

    private DDNhanVienMapperImpl DDNhanVienMapper;
    private DDNhanVienRepository repository;

    @Override
    public ApiObjectBaseResponse<DDNhanVienResponse> getNhanVienByID(UUID id) {
        if (!repository.existsById(id)){
            throw new NotFoundException("Mã nhân viên" + id + " chưa tồn tại");
        }
        return new ApiObjectBaseResponse<>(ExceptionCode.SUCCESS.getCode(), ExceptionCode.SUCCESS.getDetail(), DDNhanVienMapper.changeToResponseEntity(repository.getEntityById(id)));
    }

    @Override
    @Transactional
    public BasePage<DDNhanVienResponse> getAll() {
        ApiListBaseRequest req = new ApiListBaseRequest();
        List<DDNhanVien> data = repository.findAll();
        return new BasePage<>(req.getPage(), req.getSize(), (long) repository.findAll().size(), DDNhanVienMapper.changeToListResponseEntity(data), repository.findAll().size() / req.getSize());
    }

    @Override
    @Transactional
    public BasePage<DDNhanVienResponse> getAllPage(int page) {
        ApiListBaseRequest req = new ApiListBaseRequest();
        List<DDNhanVien> data = repository.findAll(Paging.buildPageRequest(req, page)).getContent();

        return new BasePage<>(req.getPage(), req.getSize(), (long) repository.findAll().size(), DDNhanVienMapper.changeToListResponseEntity(data), repository.findAll().size() / req.getSize());
    }

    @Override
    @Transactional
    public BasePage<DDNhanVienResponse> search(DDNhanVienSearchEntity searchData) {
        ApiListBaseRequest req = new ApiListBaseRequest();
        req.setPage(searchData.getPage());
        List<DDNhanVien> data = repository.searchingElement(searchData.getKeyword().toLowerCase(), searchData.getTeam(), searchData.getPhone(), Search.getGender(searchData.getGender()), searchData.getBirdDateFrom(), searchData.getBirdDateTo());
        if (data.size()/req.getSize() < searchData.getPage()){
            throw new PageNotExistedException("Yêu cầu không thể xử lí vì số page vượt quá yêu cầu");
        }
        data.sort(Comparator.comparing(DDNhanVien::getCode));
        List<DDNhanVien> result = Search.filterDataByPage(data, searchData.getPage(), req.getSize());
        return new BasePage<>(req.getPage(), req.getSize(), (long) data.size(), DDNhanVienMapper.changeToListResponseEntity(result), data.size() / req.getSize());
    }

    @Override
    @Transactional
    public ApiObjectBaseResponse<DDNhanVien> update(DDNhanVienUpdate dataUpdate) {
        if (!repository.existsById(dataUpdate.getId())){
            throw new ExistedException("Nhân viên có tên " + dataUpdate.getName() + " chưa tồn tại");
        }
        DDNhanVien dd = repository.getEntityById(dataUpdate.getId());
        if (dataUpdate.getName() == null || dataUpdate.getName().length() > 255){
            return new ApiResponseBuild<DDNhanVien>().invalidName();
        }
        if (UniteValidation.validPhone(dataUpdate.getPhone())){
            return new ApiResponseBuild<DDNhanVien>().invalidPhone();
        }
        if (UniteValidation.validEmail(dataUpdate.getEmail())){
            return new ApiResponseBuild<DDNhanVien>().invalidEmail();
        }
        if (!UniteValidation.vaildBirth(dataUpdate.getBirth())){
            return new ApiResponseBuild<DDNhanVien>().invalidBirth();
        }
        if (repository.existsByEmail(dataUpdate.getEmail()) && !dataUpdate.getEmail().equals(dd.getEmail())){
            return new ApiResponseBuild<DDNhanVien>().existsEmail();
        }
        if ((repository.existsByName(dataUpdate.getName()) && !dataUpdate.getName().equals(dd.getName()) )|| (repository.existsByPhone(dataUpdate.getPhone()) && !dataUpdate.getPhone().equals(dd.getPhone()))){
            return new ApiResponseBuild<DDNhanVien>().exists();
        }
        DDNhanVien entity = repository.save(DDNhanVienMapper.changeDataUpdateToEntity(dataUpdate.getId(), dataUpdate));
        return new ApiObjectBaseResponse<>(ExceptionCode.SUCCESS.getCode(), ExceptionCode.SUCCESS.getDetail(), entity);
    }

    @Override
    @Transactional
    public ApiBaseResponse delete(UUID id) {
        if (!repository.existsById(id)){
            throw new NotFoundException("Mã nhân viên" + id + " chưa tồn tại");
        }
        repository.delete(repository.getEntityById(id));
        return new ApiResponseBuild<>().success();
    }

    @Override
    @Transactional
    public ApiObjectBaseResponse<DDNhanVien> create(DDNhanVienCreate dataCreate) {
        if (dataCreate.getName() == null || dataCreate.getName().length() > 255){
            return new ApiResponseBuild<DDNhanVien>().invalidName();
        }
        if (UniteValidation.validPhone(dataCreate.getPhone())){
            return new ApiResponseBuild<DDNhanVien>().invalidPhone();
        }
        if (UniteValidation.validEmail(dataCreate.getEmail())){
            return new ApiResponseBuild<DDNhanVien>().invalidEmail();
        }
        if (!UniteValidation.vaildBirth(dataCreate.getBirth())){
            return new ApiResponseBuild<DDNhanVien>().invalidBirth();
        }
        if (repository.existsByEmail(dataCreate.getEmail())){
            return new ApiResponseBuild<DDNhanVien>().existsEmail();
        }
        if (repository.existsByName(dataCreate.getName()) || repository.existsByPhone(dataCreate.getPhone())){
            return new ApiResponseBuild<DDNhanVien>().exists();
        }
        DDNhanVien entity = repository.save(DDNhanVienMapper.changeToEntity(dataCreate));
        return new ApiResponseBuild<DDNhanVien>().successObject(entity);
    }
}
