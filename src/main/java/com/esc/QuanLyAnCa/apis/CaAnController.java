package com.esc.QuanLyAnCa.apis;

import com.esc.QuanLyAnCa.core.MessageModel;
import com.esc.QuanLyAnCa.entities.CaAn;
import com.esc.QuanLyAnCa.models.dangkycaan.DangKyCaNhanModel;
import com.esc.QuanLyAnCa.models.dangkycaan.DangKyTapTheModel;
import com.esc.QuanLyAnCa.services.CaAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
       

@RestController
@RequestMapping("/api/v1")
public class CaAnController {

    @Autowired
    private CaAnService caanService;
    @PostMapping("/dangkycanhan")
    public ResponseEntity<MessageModel> dangkycanhanHandler(@RequestBody DangKyCaNhanModel data){
        caanService.dangkycanhanHandler(data);
        return ResponseEntity.ok(MessageModel.builder().devMsg("dang ky thanh cong").userMsg("Đăng ký ca ăn thành công").build());
    }
    @PostMapping("/dangkytapthe")
    public ResponseEntity<MessageModel> dangkytaptheHandler(@RequestBody DangKyTapTheModel data){
        caanService.dangkytaptheHandler(data);
        return ResponseEntity.ok(MessageModel.builder().devMsg("dang ky thanh cong").userMsg("Đăng ký tập thể thành công").build());
    }
    @PostMapping("/caan")
    public CaAn save(@RequestBody CaAn caan){
        return caanService.save(caan);
    }

    @GetMapping("/caan/{id}")
    public Optional<CaAn> getById(@PathVariable(value = "id") String id){
        return caanService.find(id);
    }

    @GetMapping("/caan")
    public List<CaAn> getAll(){
        return caanService.findAll();
    }

    @DeleteMapping("/caan/{id}")
    public void deleteById(@PathVariable(value = "id") String id){
        caanService.delete(id);
    }

    @DeleteMapping("/caan")
    public void deleteAll(){
        caanService.deleteAll();
    }

    @GetMapping("/caan/count")
    public long count(){
        return caanService.count();
    }
}