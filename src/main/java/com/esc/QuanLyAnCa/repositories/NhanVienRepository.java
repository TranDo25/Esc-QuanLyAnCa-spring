package com.esc.QuanLyAnCa.repositories;

import com.esc.QuanLyAnCa.entities.NhanVien;
import com.esc.QuanLyAnCa.models.thongke.ThongKeTheoNgayModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    @Query(value="select * from NhanVien a where a.username= :username", nativeQuery=true)
    Optional<NhanVien> findByUsername(String username);

    List<NhanVien> findByPhongBanId(String id);

    Page<NhanVien> findByUsernameContainingOrEmailContaining(String keyword, String keyword1, Pageable pageable);

    @Query("SELECT nv FROM NhanVien nv " +
            "WHERE (:nhanVienCode IS NULL OR nv.nhanVienCode = :nhanVienCode) " +
            "  AND (:phongBanId IS NULL OR nv.phongBanId = :phongBanId) " +
            "  AND (:nhanVienName IS NULL OR nv.nhanVienName LIKE %:nhanVienName%) " +
            "  AND (:startDate IS NULL OR nv.createdDate >= :startDate) " +
            "  AND (:endDate IS NULL OR nv.createdDate <= :endDate)")
    Page<NhanVien> search(String nhanVienCode, String phongBanId, String nhanVienName,
                          String startDate, String endDate, Pageable pageable);
}