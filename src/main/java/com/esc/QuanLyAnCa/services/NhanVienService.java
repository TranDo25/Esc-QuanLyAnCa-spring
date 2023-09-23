package com.esc.QuanLyAnCa.services;

import com.esc.QuanLyAnCa.entities.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface NhanVienService {

    NhanVien save(NhanVien nhanvien);

    Optional<NhanVien> find(String id);

    List<NhanVien> findAll();

    List<NhanVien> findAll(List<String> ids);

    List<NhanVien> findAll(Sort sort);

    Page<NhanVien> findAll(Pageable pageable);
    Page<NhanVien> findAll(int pageNumber, int pageSize);

    void delete(String id);

    void delete(List<NhanVien> nhanvien);

    void delete(NhanVien nhanvien);

    void deleteAll();

    long count();

    NhanVien update(String id, NhanVien updatedEmployee);

    List<NhanVien> getAllNhanVienByDepartmentId(String id);

    Optional<NhanVien> getNhanVienByUsername(String username);

    Page<NhanVien> search(String keyword, int page, int size);

    Page<NhanVien> search(String nhanVienCode, String phongBanId, String nhanVienName, String startDate, String endDate, int page, int size);
}