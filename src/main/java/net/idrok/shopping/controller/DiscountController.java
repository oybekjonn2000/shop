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
import net.idrok.shopping.entity.Discount;
import net.idrok.shopping.service.DiscountService;



@RestController
@RequestMapping("/api/discount")
@CrossOrigin(maxAge = 3600)
public class DiscountController {


    @Autowired
    DiscountService discountSvc;

    @GetMapping()
    public ResponseEntity<Page<Discount>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(discountSvc.getAll(pageable, key));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discount> getById(@PathVariable Long id){
        return ResponseEntity.ok(discountSvc.getById(id));
    }

    @PostMapping()
    public ResponseEntity<Discount> create(@RequestBody Discount ch){
        return ResponseEntity.ok( discountSvc.create(ch));
    }

    @PutMapping()
    public ResponseEntity<Discount> update(@RequestBody Discount ch){
        return ResponseEntity.ok(discountSvc.update(ch));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        discountSvc.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}