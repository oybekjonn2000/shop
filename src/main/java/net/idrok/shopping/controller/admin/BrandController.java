package net.idrok.shopping.controller.admin;

import net.idrok.shopping.entity.Brand;
import net.idrok.shopping.service.BrandService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/brand")
@CrossOrigin(maxAge = 3600)
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping()
    public ResponseEntity<Page<Brand>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(brandService.getAll(pageable, key));
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
