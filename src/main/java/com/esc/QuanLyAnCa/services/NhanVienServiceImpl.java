package com.esc.QuanLyAnCa.services;

import com.esc.QuanLyAnCa.entities.NhanVien;
import com.esc.QuanLyAnCa.repositories.NhanVienRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanvienRepository;


    public Page<NhanVien> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return nhanvienRepository.findAll(pageable);
    }

    @Override
    public NhanVien save(NhanVien nhanvien) {
        return nhanvienRepository.save(nhanvien);
    }

    @Override
    public Optional<NhanVien> find(String id) {
        return nhanvienRepository.findById(id);
    }

    @Override
    public List<NhanVien> findAll() {
        return nhanvienRepository.findAll();
    }

    @Override
    public List<NhanVien> findAll(List<String> ids) {
        return nhanvienRepository.findAllById(ids);
    }

    @Override
    public List<NhanVien> findAll(Sort sort) {
        return nhanvienRepository.findAll(sort);
    }

    @Override
    public Page<NhanVien> findAll(Pageable pageable) {
        return nhanvienRepository.findAll(pageable);
    }

    @Override
    public void delete(String id) {
        nhanvienRepository.deleteById(id);
    }

    @Override
    public void delete(List<NhanVien> nhanvien) {
        nhanvienRepository.delete((NhanVien) nhanvien);
    }

    @Override
    public void delete(NhanVien nhanvien) {
        nhanvienRepository.delete(nhanvien);
    }

    @Override
    public void deleteAll() {
        nhanvienRepository.deleteAll();
    }

    @Override
    public long count() {
        return nhanvienRepository.count();
    }

    @Override
    public NhanVien update(String id, NhanVien updatedEmployee) {
        return nhanvienRepository.findById(id)
                .map(employee -> {
                    // Sao chép dữ liệu từ updatedEmployee vào employee hiện tại
                    BeanUtils.copyProperties(updatedEmployee, employee, "nhanVienId");
                    return nhanvienRepository.save(employee);
                })
                .orElseGet(() -> {
                    // Nếu không tìm thấy nhân viên, trả về null hoặc xử lý thêm theo nhu cầu
                    return null;
                });
    }

    @Override
    public List<NhanVien> getAllNhanVienByDepartmentId(String id) {
        return nhanvienRepository.findByPhongBanId(id);
    }

    @Override
    public Optional<NhanVien> getNhanVienByUsername(String username) {

        return nhanvienRepository.findByUsername(username);

    }

    @Override
    public Page<NhanVien> search(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return nhanvienRepository.findByUsernameContainingOrEmailContaining(keyword, keyword, pageable);
    }

    @Override
    public Page<NhanVien> search(String nhanVienCode, String phongBanId, String nhanVienName,
                                 String startDate, String endDate, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return nhanvienRepository.search(nhanVienCode, phongBanId, nhanVienName, startDate, endDate, pageable);
    }

}