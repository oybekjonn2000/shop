package net.idrok.shopping.controller.admin;
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
    BrandService brandService;

    @GetMapping()
    public ResponseEntity<Page<Brand>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(brandService.getAll(key, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getById(@PathVariable Long id){
        return ResponseEntity.ok(brandService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<Brand> create(@RequestBody Brand kt){
        return ResponseEntity.ok( brandService.create(kt));
    }

    @PutMapping()
    public ResponseEntity<Brand> update(@RequestBody Brand kt){
        return ResponseEntity.ok(brandService.update(kt));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        brandService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}