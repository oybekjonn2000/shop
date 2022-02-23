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

import net.idrok.shopping.entity.Kategoriya;
import net.idrok.shopping.service.KategoriyaService;

@RestController
@RequestMapping("/api/kategoriya")
@CrossOrigin(maxAge = 3600)
public class KategoriyaController {
    @Autowired
    KategoriyaService kategoriyaSVC;

    @GetMapping()
    public ResponseEntity<Page<Kategoriya>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(kategoriyaSVC.getAll(key, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kategoriya> getById(@PathVariable Long id){
        return ResponseEntity.ok(kategoriyaSVC.getById(id));
    }

    @PostMapping()
    public ResponseEntity<Kategoriya> create(@RequestBody Kategoriya kt){
        return ResponseEntity.ok( kategoriyaSVC.create(kt));
    }

    @PutMapping()
    public ResponseEntity<Kategoriya> update(@RequestBody Kategoriya kt){
        return ResponseEntity.ok(kategoriyaSVC.update(kt));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        kategoriyaSVC.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    
    
}
