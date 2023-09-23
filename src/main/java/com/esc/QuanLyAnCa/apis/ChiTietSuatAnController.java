package com.esc.QuanLyAnCa.apis;

import com.esc.QuanLyAnCa.entities.ChiTietSuatAn;
import com.esc.QuanLyAnCa.services.ChiTietSuatAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class ChiTietSuatAnController {

    @Autowired
    private ChiTietSuatAnService chitietsuatanService;

    @PostMapping("/chitietsuatan")
    public ChiTietSuatAn save(@RequestBody ChiTietSuatAn chitietsuatan){
        return chitietsuatanService.save(chitietsuatan);
    }

    @GetMapping("/chitietsuatan/{id}")
    public Optional<ChiTietSuatAn> getById(@PathVariable(value = "id") String id){
        return chitietsuatanService.find(id);
    }

    @GetMapping("/chitietsuatan")
    public List<ChiTietSuatAn> getAll(){
        return chitietsuatanService.findAll();
    }

    @DeleteMapping("/chitietsuatan/{id}")
    public void deleteById(@PathVariable(value = "id") String id){
        chitietsuatanService.delete(id);
    }

    @DeleteMapping("/chitietsuatan")
    public void deleteAll(){
        chitietsuatanService.deleteAll();
    }

    @GetMapping("/chitietsuatan/count")
    public long count(){
        return chitietsuatanService.count();
    }
}