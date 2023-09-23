package com.esc.QuanLyAnCa.apis;

import com.esc.QuanLyAnCa.entities.SuatAn;
import com.esc.QuanLyAnCa.services.SuatAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
       

@RestController
@RequestMapping("")
public class SuatAnController {

    @Autowired
    private SuatAnService suatanService;

    @PostMapping("/suatan")
    public SuatAn save(@RequestBody SuatAn suatan){
        return suatanService.save(suatan);
    }

    @GetMapping("/suatan/{id}")
    public Optional<SuatAn> getById(@PathVariable(value = "id") String id){
        return suatanService.find(id);
    }

    @GetMapping("/suatan")
    public List<SuatAn> getAll(){
        return suatanService.findAll();
    }

    @DeleteMapping("/suatan/{id}")
    public void deleteById(@PathVariable(value = "id") String id){
        suatanService.delete(id);
    }

    @DeleteMapping("/suatan")
    public void deleteAll(){
        suatanService.deleteAll();
    }

    @GetMapping("/suatan/count")
    public long count(){
        return suatanService.count();
    }
}