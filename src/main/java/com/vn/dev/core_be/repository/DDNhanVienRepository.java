package com.vn.dev.core_be.repository;

import com.vn.dev.core_be.entity.DDNhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface DDNhanVienRepository extends JpaRepository<DDNhanVien, UUID>, JpaSpecificationExecutor<DDNhanVien> {

    DDNhanVien getEntityById(UUID id);

    Boolean getExistsEntityById(UUID id);

    @Query(value = "SELECT * FROM dd_nhanvien d WHERE d.NAME = name", nativeQuery = true)
    DDNhanVien findEntityByName(String name);

    @Query(value = "SELECT * FROM dd_nhanvien d WHERE d.NAME = keyword", nativeQuery = true)
    List<DDNhanVien> searchingElement(String keyword, String team, String phone, String gender, Date birdDateFrom, Date birdDateTo);

}
