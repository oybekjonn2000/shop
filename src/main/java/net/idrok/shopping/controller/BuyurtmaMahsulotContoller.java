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
import net.idrok.shopping.entity.BuyurtmaMahsulot;
import net.idrok.shopping.service.BuyurtmaMahsulotService;


@RestController
@RequestMapping("/api/buyurtmaa")
@CrossOrigin(maxAge = 3600)

public class BuyurtmaMahsulotContoller {

    @Autowired
    BuyurtmaMahsulotService buyurtmaMahsulotService;

    @GetMapping()
    public ResponseEntity<Page<BuyurtmaMahsulot>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(buyurtmaMahsulotService.getAll(key, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuyurtmaMahsulot> getById(@PathVariable Long id){
        return ResponseEntity.ok(buyurtmaMahsulotService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<BuyurtmaMahsulot> create(@RequestBody BuyurtmaMahsulot bm){
        return ResponseEntity.ok( buyurtmaMahsulotService.create(bm));
    }

    @PutMapping()
    public ResponseEntity<BuyurtmaMahsulot> update(@RequestBody BuyurtmaMahsulot bm){
        return ResponseEntity.ok(buyurtmaMahsulotService.update(bm));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        buyurtmaMahsulotService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    
}
