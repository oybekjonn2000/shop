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

@RestController
@RequestMapping("/api/mijoz")
@CrossOrigin(maxAge = 3600)
public class MijozController {


    @Autowired
    MijozService mijozService;

    @GetMapping()
    public ResponseEntity<Page<Mijoz>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(mijozService.getAll(key, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mijoz> getById(@PathVariable Long id){
        return ResponseEntity.ok(mijozService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<Mijoz> create(@RequestBody Mijoz mj){
        return ResponseEntity.ok( mijozService.create(mj));
    }

    @PutMapping()
    public ResponseEntity<Mijoz> update(@RequestBody Mijoz mj){
        return ResponseEntity.ok(mijozService.update(mj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        mijozService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}