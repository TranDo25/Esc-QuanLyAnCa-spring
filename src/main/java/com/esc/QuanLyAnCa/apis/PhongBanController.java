package com.esc.QuanLyAnCa.apis;

import com.esc.QuanLyAnCa.entities.PhongBan;
import com.esc.QuanLyAnCa.services.PhongBanService;
import jakarta.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class PhongBanController {

    @Autowired
    private PhongBanService phongbanService;
    private static final Logger logger = Logger.getLogger(String.valueOf(PhongBanController.class));


    @PutMapping("phongban/{id}")
    public ResponseEntity<?> updatePhongBan(@PathVariable String id, @Valid @RequestBody PhongBan updatedPhongBan,
                                            BindingResult result
    ) {
        if (result.hasErrors()) {
            // Nếu có lỗi trong dữ liệu đầu vào
            Map<String, String> errorMap = new HashMap<>();
            result.getFieldErrors().forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
            logger.error(errorMap);

            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
        PhongBan savedPhongBan = phongbanService.update(id, updatedPhongBan);
        return new ResponseEntity<>(savedPhongBan, HttpStatus.OK);

    }

    @PostMapping("/phongban")
    public ResponseEntity<?> save(@Valid @RequestBody PhongBan phongban,
                                  BindingResult result
    ) {
        if (result.hasErrors()) {
            // Nếu có lỗi trong dữ liệu đầu vào
            Map<String, String> errorMap = new HashMap<>();
            result.getFieldErrors().forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
            logger.error(errorMap);

            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
        PhongBan savedPhongBan = phongbanService.save(phongban);
        return new ResponseEntity<>(savedPhongBan, HttpStatus.CREATED);
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