package net.idrok.shopping.controller.admin;

import net.idrok.shopping.entity.City;
import net.idrok.shopping.service.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/city")
@CrossOrigin(maxAge = 3600)
public class CityController {


 private final   CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping()
    public ResponseEntity<Page<City>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(cityService.getAll(pageable, key));
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getById(@PathVariable Long id){
        return ResponseEntity.ok(cityService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<City> create(@RequestBody City kt){
        return ResponseEntity.ok( cityService.create(kt));
    }

    @PutMapping()
    public ResponseEntity<City> update(@RequestBody City kt){
        return ResponseEntity.ok(cityService.update(kt));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        cityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findByProvinceCode")
    public ResponseEntity<Page<City>> getByProvinceCode(@RequestParam(name="code", required = false) String code,   Pageable pageable){
        return ResponseEntity.ok(cityService.findByProvinceCode(code, pageable));
    }

}
