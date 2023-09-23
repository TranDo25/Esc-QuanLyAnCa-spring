package com.esc.QuanLyAnCa.services;

import com.esc.QuanLyAnCa.entities.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienV2Service {
    @PersistenceContext
    private EntityManager entityManager;

    public Page<NhanVien> search(String nhanVienCode, String phongBanId, String nhanVienName,
                                 String startDate, String endDate, Pageable pageable) {

        // Tạo câu truy vấn JPQL cơ bản
        StringBuilder jpqlBuilder = new StringBuilder("SELECT nv FROM NhanVien nv WHERE 1=1");

        // Tạo các điều kiện tương ứng với các tham số không null
        if (nhanVienCode != null && !nhanVienCode.isEmpty()) {
            jpqlBuilder.append(" AND nv.nhanVienCode = :nhanVienCode");
        }
        if (phongBanId != null && !phongBanId.isEmpty()) {
            jpqlBuilder.append(" AND nv.phongBanId = :phongBanId");
        }
        if (nhanVienName != null && !nhanVienName.isEmpty()) {
            jpqlBuilder.append(" AND nv.nhanVienName LIKE :nhanVienName");
        }
        if (startDate != null && !startDate.isEmpty()) {
            jpqlBuilder.append(" AND nv.createdDate >= :startDate");
        }
        if (endDate != null && !endDate.isEmpty()) {
            jpqlBuilder.append(" AND nv.createdDate <= :endDate");
        }

        // Tạo truy vấn JPQL từ chuỗi
        String jpql = jpqlBuilder.toString();
        TypedQuery<NhanVien> query = entityManager.createQuery(jpql, NhanVien.class);

        // Đặt các tham số trong truy vấn
        if (nhanVienCode != null && !nhanVienCode.isEmpty()) {
            query.setParameter("nhanVienCode", nhanVienCode);
        }
        if (phongBanId != null && !phongBanId.isEmpty()) {
            query.setParameter("phongBanId", phongBanId);
        }
        if (nhanVienName != null && !nhanVienName.isEmpty()) {
            query.setParameter("nhanVienName", "%" + nhanVienName + "%");
        }
        if (startDate != null && !startDate.isEmpty()) {
            query.setParameter("startDate", startDate);
        }
        if (endDate != null && !endDate.isEmpty()) {
            query.setParameter("endDate", endDate);
        }

        // Đặt phân trang
        int totalResults = query.getResultList().size();
        int firstResult = pageable.getPageNumber() * pageable.getPageSize();
        query.setFirstResult(firstResult);
        query.setMaxResults(pageable.getPageSize());

        List<NhanVien> resultList = query.getResultList();

        return new PageImpl<>(resultList, pageable, totalResults);
    }
}
