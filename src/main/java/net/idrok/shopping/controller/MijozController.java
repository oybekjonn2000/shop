package net.idrok.shopping.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import net.idrok.shopping.entity.Mijoz;
import net.idrok.shopping.service.MijozService;
import net.idrok.shopping.service.dto.MijozDTO;

@RestController
@RequestMapping("/api/mijoz")
@CrossOrigin(maxAge = 3600)
public class MijozController {


    @Autowired
    MijozService mjService;

    @GetMapping()
    public ResponseEntity<Page<MijozDTO>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(mjService.getAll(key, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MijozDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(mjService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<MijozDTO> create(@RequestBody Mijoz mj){
        return ResponseEntity.ok( mjService.create(mj));
    }

    @PutMapping()
    public ResponseEntity<MijozDTO> update(@RequestBody Mijoz mj){
        return ResponseEntity.ok(mjService.update(mj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        mjService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}