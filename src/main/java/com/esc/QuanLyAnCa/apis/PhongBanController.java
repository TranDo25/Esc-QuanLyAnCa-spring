package com.esc.QuanLyAnCa.apis;

import com.esc.QuanLyAnCa.entities.PhongBan;
import com.esc.QuanLyAnCa.services.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class PhongBanController {

    @Autowired
    private PhongBanService phongbanService;



    @PutMapping("phongban/{id}")
    public PhongBan updatePhongBan(@PathVariable String id, @RequestBody PhongBan updatedPhongBan) {
        return phongbanService.update(id, updatedPhongBan);

    }

    @PostMapping("/phongban")
    public PhongBan save(@RequestBody PhongBan phongban) {
        return phongbanService.save(phongban);
    }

    @GetMapping("/phongban/{id}")
    public Optional<PhongBan> getById(@PathVariable(value = "id") String id) {
        return phongbanService.find(id);
    }

    @GetMapping("/phongban")
    public List<PhongBan> getAll() {
        return phongbanService.findAll();
    }

    @DeleteMapping("/phongban/{id}")
    public void deleteById(@PathVariable(value = "id") String id) {
        phongbanService.delete(id);
    }

    @DeleteMapping("/phongban")
    public void deleteAll() {
        phongbanService.deleteAll();
    }

    @GetMapping("/phongban/count")
    public long count() {
        return phongbanService.count();
    }
}