package com.vn.dev.core_be.service.DDNhanVien;

import com.vn.dev.core_be.dto.ddnhanvien.request.DDNhanVienCreate;
import com.vn.dev.core_be.dto.ddnhanvien.request.DDNhanVienSearchEntity;
import com.vn.dev.core_be.entity.DDNhanVien;
import com.vn.dev.core_be.mapper.DDNhanVienMapperImpl;
import com.vn.dev.core_be.repository.DDNhanVienRepository;
import io.swagger.models.Response;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return null;
    }

    @Override
    public Page<DDNhanVien> search(DDNhanVienSearchEntity searchData) {
        return null;
    }

    @Override
    public void update(UUID id, DDNhanVien dataUpdate) {

    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    @Transactional
//    @CacheEvict(allEntries = true)
    public Response create(DDNhanVienCreate dataCreate) {
        if (repository.findEntityByName(dataCreate.getName())){
            return null;
        }
        DDNhanVien entity = repository.save(DDNhanVienMapper.changeToEntity(dataCreate));
        repository.save(entity);
        return null;
    }
}
