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

import net.idrok.shopping.entity.Brand;
import net.idrok.shopping.service.BrandService;


@RestController
@RequestMapping("/api/brand")
@CrossOrigin(maxAge = 3600)
public class BrandController {
    @Autowired
    BrandService brandSvc;

    @GetMapping()
    public ResponseEntity<Page<Brand>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(brandSvc.getAll(pageable, key));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getById(@PathVariable Long id){
        return ResponseEntity.ok(brandSvc.getById(id));
    }

    @PostMapping()
    public ResponseEntity<Brand> create(@RequestBody Brand kt){
        return ResponseEntity.ok( brandSvc.create(kt));
    }

    @PutMapping()
    public ResponseEntity<Brand> update(@RequestBody Brand kt){
        return ResponseEntity.ok(brandSvc.update(kt));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        brandSvc.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
