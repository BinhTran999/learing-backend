package com.vn.dev.core_be.repository;

import com.vn.dev.core_be.entity.DDNhanVien;
import io.lettuce.core.dynamic.annotation.Param;
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

//    @Query(value = "SELECT IS_ACTIVE FROM dd_nhanvien2 WHERE id = ?1", nativeQuery = true)
    boolean existsById(UUID id);

    boolean existsByEmail(String email);

    boolean existsByCode(String code);

    boolean existsByName(String name);

    boolean existsByPhone(String phone);

    @Query(value = "SELECT * FROM dd_nhanvien2 ORDER BY code DESC LIMIT 1", nativeQuery = true)
    DDNhanVien findTopByOrderByIdDesc();

    @Query(value = "SELECT * FROM dd_nhanvien2 d " +
            "WHERE POSITION(?1 IN LOWER(d.name)) > 0 " +
            "AND POSITION(?2 IN d.team) > 0 " +
            "AND POSITION(?3 IN d.phone) > 0 " +
            "AND (CASE WHEN ?4 IS NULL THEN 1 = 1 ELSE d.gender = ?4 END) " +
            "AND( (CASE WHEN CAST(?5 AS DATE) IS NULL AND CAST(?6 AS DATE) IS NULL THEN 1 = 1 END)  " +
            "OR (CASE WHEN CAST(?5 AS DATE) IS NULL AND CAST(?6 AS DATE)  IS NOT NULL THEN d.birth <= CAST(?6 AS DATE) END)  " +
            "OR (CASE WHEN CAST(?5 AS DATE) IS NOT NULL AND CAST(?6 AS DATE) IS NULL THEN d.birth >= CAST(?5 AS DATE) END)  " +
            "OR (CASE WHEN CAST(?5 AS DATE) IS NOT NULL AND CAST(?6 AS DATE) IS NOT NULL THEN d.birth <= CAST(?6 AS DATE) AND d.birth >= CAST(?5 AS DATE) END) ) " ,

            nativeQuery = true)

    List<DDNhanVien> searchingElement(String keyword,
                                      String team,
                                      String phone,
                                      String gender,
                                      Date birdDateFrom,
                                      Date birdDateTo);


    @Query(value = "SELECT d.code FROM dd_nhanvien2 d WHERE d.id = ?1", nativeQuery = true)
    String getCodeForID(UUID id);

//    @Query(value = "SELECT d.code FROM dd_nhanvien2 d WHERE d.id = ?1", nativeQuery = true)
//    String getIDForCode(UUID id);
}
