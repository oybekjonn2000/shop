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
import net.idrok.shopping.entity.OrderItem;
import net.idrok.shopping.service.OrderItemService;


@RestController
@RequestMapping("/api/orderitem")
@CrossOrigin(maxAge = 3600)

public class OrderItemContoller {

    @Autowired
    OrderItemService orderItemSVC;

    @GetMapping()
    public ResponseEntity<Page<OrderItem>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(orderItemSVC.getAll(key, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getById(@PathVariable Long id){
        return ResponseEntity.ok(orderItemSVC.getById(id));
    }

    @PostMapping()
    public ResponseEntity<OrderItem> create(@RequestBody OrderItem bm){
        return ResponseEntity.ok( orderItemSVC.create(bm));
    }

    @PutMapping()
    public ResponseEntity<OrderItem> update(@RequestBody OrderItem bm){
        return ResponseEntity.ok(orderItemSVC.update(bm));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        orderItemSVC.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    
}
