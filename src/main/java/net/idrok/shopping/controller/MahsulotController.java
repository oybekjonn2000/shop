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
import net.idrok.shopping.entity.Mahsulot;
import net.idrok.shopping.service.MahsulotService;


@RestController
@RequestMapping("/api/mahsulot")
@CrossOrigin(maxAge = 3600)

public class MahsulotController {

    @Autowired
    MahsulotService mahsulotService;

    @GetMapping()
    public ResponseEntity<Page<Mahsulot>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(mahsulotService.getAll(key, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mahsulot> getById(@PathVariable Long id){
        return ResponseEntity.ok(mahsulotService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<Mahsulot> create(@RequestBody Mahsulot bm){
        return ResponseEntity.ok( mahsulotService.create(bm));
    }

    @PutMapping()
    public ResponseEntity<Mahsulot> update(@RequestBody Mahsulot bm){
        return ResponseEntity.ok(mahsulotService.update(bm));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        mahsulotService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    
}
