package com.esc.QuanLyAnCa.services;

import com.esc.QuanLyAnCa.entities.ChiTietSuatAn;
import com.esc.QuanLyAnCa.repositories.ChiTietSuatAnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class ChiTietSuatAnServiceImpl implements ChiTietSuatAnService {

    @Autowired
    private ChiTietSuatAnRepository chitietsuatanRepository;

    @Override
    public ChiTietSuatAn save(ChiTietSuatAn chitietsuatan) {
        return chitietsuatanRepository.save(chitietsuatan);
    }

    @Override
    public Optional<ChiTietSuatAn> find(String id) {
        return chitietsuatanRepository.findById(id);
    }

    @Override
    public List<ChiTietSuatAn> findAll() {
        return chitietsuatanRepository.findAll();
    }

    @Override
    public List<ChiTietSuatAn> findAll(List<String> ids) {
        return chitietsuatanRepository.findAllById(ids);
    }

    @Override
    public List<ChiTietSuatAn> findAll(Sort sort) {
        return chitietsuatanRepository.findAll(sort);
    }

    @Override
    public Page<ChiTietSuatAn> findAll(Pageable pageable) {
        return chitietsuatanRepository.findAll(pageable);
    }

    @Override
    public void delete(String id) {
        chitietsuatanRepository.deleteById(id);
    }

    @Override
    public void delete(List<ChiTietSuatAn> chitietsuatan) {
        chitietsuatanRepository.delete((ChiTietSuatAn) chitietsuatan);
    }

    @Override
    public void delete(ChiTietSuatAn chitietsuatan) {
        chitietsuatanRepository.delete(chitietsuatan);
    }

    @Override
    public void deleteAll() {
        chitietsuatanRepository.deleteAll();
    }

    @Override
    public long count() {
        return chitietsuatanRepository.count();
    }

}