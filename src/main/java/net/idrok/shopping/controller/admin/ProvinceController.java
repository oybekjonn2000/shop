package net.idrok.shopping.controller.admin;

import net.idrok.shopping.entity.Province;
import net.idrok.shopping.service.ProvinceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/province")
@CrossOrigin(maxAge = 3600)
public class ProvinceController {

    private final
    ProvinceService provinceService;

    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @GetMapping()
    public ResponseEntity<Page<Province>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(provinceService.getAll(pageable, key));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Province> getById(@PathVariable Long id){
        return ResponseEntity.ok(provinceService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<Province> create(@RequestBody Province kt){
        return ResponseEntity.ok( provinceService.create(kt));
    }

    @PutMapping()
    public ResponseEntity<Province> update(@RequestBody Province kt){
        return ResponseEntity.ok(provinceService.update(kt));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        provinceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
