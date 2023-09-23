package com.esc.QuanLyAnCa.services;

import com.esc.QuanLyAnCa.entities.PhongBan;
import com.esc.QuanLyAnCa.repositories.PhongBanRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
       
@Service
public class PhongBanServiceImpl implements PhongBanService {

    @Autowired
    private PhongBanRepository phongbanRepository;

    @Override
    public PhongBan save(PhongBan phongban) {
        return phongbanRepository.save(phongban);
    }

    @Override
    public Optional<PhongBan> find(String id) {
        return phongbanRepository.findById(id);
    }

    @Override
    public List<PhongBan> findAll() {
        return phongbanRepository.findAll();
    }

    @Override
    public List<PhongBan> findAll(Sort sort){
        return phongbanRepository.findAll(sort);
    }

    @Override
    public Page<PhongBan> findAll(Pageable pageable){
        return phongbanRepository.findAll(pageable);
    }

    @Override
    public void delete(String id) {
    phongbanRepository.deleteById(id);
    }

    @Override
    public void delete(PhongBan phongban) {
        phongbanRepository.delete(phongban);
    }

    @Override
    public void deleteAll() {
        phongbanRepository.deleteAll();
    }

    @Override
    public long count() {
        return phongbanRepository.count();
    }

    @Override
    public PhongBan update(String id, PhongBan updatedPhongBan) {
        return phongbanRepository.findById(id)
                .map(phongban -> {
                    // Sao chép dữ liệu từ updatedEmployee vào employee hiện tại
                    BeanUtils.copyProperties(updatedPhongBan, phongban, "phongBanId");
                    return phongbanRepository.save(phongban);
                })
                .orElseGet(() -> {
                    // Nếu không tìm thấy nhân viên, trả về null hoặc xử lý thêm theo nhu cầu
                    return null;
                });
    }

    @Override
    public Optional<PhongBan> getPhongBanNameById(String id) {
        return phongbanRepository.findById(id);
    }

}