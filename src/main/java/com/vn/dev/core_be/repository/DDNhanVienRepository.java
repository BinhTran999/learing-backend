package com.vn.dev.core_be.repository;

import com.vn.dev.core_be.entity.DDNhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DDNhanVienRepository extends JpaRepository<DDNhanVien, UUID>, JpaSpecificationExecutor<DDNhanVien> {

    @Query()
    DDNhanVien getEntityById(UUID id);

    Boolean getExistsEntityById(UUID id);

    @Query()
    DDNhanVien findEntityByName(String name);

    @Query()
    List<DDNhanVien> getAllData();
}
