package com.esc.QuanLyAnCa.services;

import com.esc.QuanLyAnCa.entities.PhongBan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
       
public interface PhongBanService {

    PhongBan save(PhongBan phongban);

    Optional<PhongBan> find(String id);

    List<PhongBan> findAll();

    List<PhongBan> findAll(Sort sort);

    Page<PhongBan> findAll(Pageable pageable);

    void delete(String id);

    void delete(PhongBan phongban);

    void deleteAll();

    long count();

    PhongBan update(String id, PhongBan updatedPhongBan);

    Optional<PhongBan> getPhongBanNameById(String id);
}