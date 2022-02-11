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

import net.idrok.shopping.entity.Buyurtma;
import net.idrok.shopping.service.BuyurtmaService;


@RestController
@RequestMapping("/api/buyurtma")
@CrossOrigin(maxAge = 3600)

public class BuyurtmaController {

    @Autowired
    BuyurtmaService buyurtmaService;

    @GetMapping()
    public ResponseEntity<Page<Buyurtma>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(buyurtmaService.getAll(key, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buyurtma> getById(@PathVariable Long id){
        return ResponseEntity.ok(buyurtmaService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<Buyurtma> create(@RequestBody Buyurtma bm){
        return ResponseEntity.ok( buyurtmaService.create(bm));
    }

    @PutMapping()
    public ResponseEntity<Buyurtma> update(@RequestBody Buyurtma bm){
        return ResponseEntity.ok(buyurtmaService.update(bm));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        buyurtmaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    
}
