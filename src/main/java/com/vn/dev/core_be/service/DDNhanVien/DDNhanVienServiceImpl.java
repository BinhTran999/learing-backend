package com.vn.dev.core_be.service.DDNhanVien;

import com.vn.dev.core_be.dto.ddnhanvien.request.DDNhanVienCreate;
import com.vn.dev.core_be.dto.ddnhanvien.request.DDNhanVienSearchEntity;
import com.vn.dev.core_be.dto.ddnhanvien.request.DDNhanVienUpdate;
import com.vn.dev.core_be.dto.ddnhanvien.response.DDObjectBaseResponse;
import com.vn.dev.core_be.entity.DDNhanVien;
import com.vn.dev.core_be.exception.ExceptionCode;
import com.vn.dev.core_be.mapper.DDNhanVienMapperImpl;
import com.vn.dev.core_be.repository.DDNhanVienRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DDNhanVienServiceImpl implements DDNhanVienService {

    @Autowired
    private DDNhanVienMapperImpl DDNhanVienMapper;

    @Autowired
    private DDNhanVienRepository repository;

    @Override
    public DDNhanVien getNhanVienByID(UUID id) {
        return null;
    }

    @Override
    public Page<DDNhanVien> getAll() {
        List<DDNhanVien> allNV = repository.getAllData();
        return null;

    }

    @Override
    public Page<DDNhanVien> search(DDNhanVienSearchEntity searchData) {
        return null;
    }

    @Override
    public DDObjectBaseResponse update(UUID id, DDNhanVienUpdate dataUpdate) {
        if (!repository.getExistsEntityById(id)){
            return new DDObjectBaseResponse(ExceptionCode.USER_EXISTED, null);
        }
        DDNhanVien entity = DDNhanVienMapper.changeDataUpdateToEntity(dataUpdate);
        entity.setId(id);
        return null;
    }

    @Override
    public void delete(UUID id) {
        repository.delete(repository.getEntityById(id));
    }

    @Override
    @Transactional
//    @CacheEvict(allEntries = true)
    public DDObjectBaseResponse create(DDNhanVienCreate dataCreate) {
        if (repository.findEntityByName(dataCreate.getName()) == null){
            return new DDObjectBaseResponse(ExceptionCode.USER_EXISTED, null);
        }
        DDNhanVien entity = repository.save(DDNhanVienMapper.changeToEntity(dataCreate));
        return new DDObjectBaseResponse(ExceptionCode.SUCCESS, repository.save(entity));
    }
}
