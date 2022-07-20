package net.idrok.shopping.controller.admin;
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
import net.idrok.shopping.entity.Order_Item;
import net.idrok.shopping.service.Order_Item_Service;



@RestController
@RequestMapping("/api/orderitem")
@CrossOrigin(maxAge = 3600)

public class Order_Item_Controller {

    private final Order_Item_Service orderItemSVC;
    public Order_Item_Controller(Order_Item_Service orderItemSVC) {
        this.orderItemSVC = orderItemSVC;
    }

    @GetMapping()
    public ResponseEntity<Page<Order_Item>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(orderItemSVC.getAll(pageable, key));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order_Item> getById(@PathVariable Long id){
        return ResponseEntity.ok(orderItemSVC.getById(id));
    }

    @PostMapping()
    public ResponseEntity<Order_Item> create(@RequestBody Order_Item bm){
        return ResponseEntity.ok( orderItemSVC.create(bm));
    }

    @PutMapping()
    public ResponseEntity<Order_Item> update(@RequestBody Order_Item bm){
        return ResponseEntity.ok(orderItemSVC.update(bm));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        orderItemSVC.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    
}
