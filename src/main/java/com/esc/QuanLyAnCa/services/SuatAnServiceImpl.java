package com.esc.QuanLyAnCa.services;

import com.esc.QuanLyAnCa.entities.SuatAn;
import com.esc.QuanLyAnCa.repositories.SuatAnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
       
@Service
public class SuatAnServiceImpl implements SuatAnService {

    @Autowired
    private SuatAnRepository suatanRepository;

    @Override
    public SuatAn save(SuatAn suatan) {
        return suatanRepository.save(suatan);
    }

    @Override
    public Optional<SuatAn> find(String id) {
        return suatanRepository.findById(id);
    }

    @Override
    public List<SuatAn> findAll() {
        return suatanRepository.findAll();
    }

    @Override
    public List<SuatAn> findAll(Sort sort){
        return suatanRepository.findAll(sort);
    }

    @Override
    public Page<SuatAn> findAll(Pageable pageable){
        return suatanRepository.findAll(pageable);
    }

    @Override
    public void delete(String id) {
    suatanRepository.deleteById(id);
    }

    @Override
    public void delete(SuatAn suatan) {
        suatanRepository.delete(suatan);
    }

    @Override
    public void deleteAll() {
        suatanRepository.deleteAll();
    }

    @Override
    public long count() {
        return suatanRepository.count();
    }

}