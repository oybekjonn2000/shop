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


import net.idrok.shopping.entity.Customer;
import net.idrok.shopping.service.CustomerService;


@RestController
@RequestMapping("/api/customer")
@CrossOrigin(maxAge = 3600)
public class CustomerController {


    @Autowired
    CustomerService customerSvc;

    @GetMapping()
    public ResponseEntity<Page<Customer>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(customerSvc.getAll(pageable, key));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id){
        return ResponseEntity.ok(customerSvc.getById(id));
    }

    @PostMapping()
    public ResponseEntity<Customer> create(@RequestBody Customer mj){
        return ResponseEntity.ok( customerSvc.create(mj));
    }

    @PutMapping()
    public ResponseEntity<Customer> update(@RequestBody Customer mj){
        return ResponseEntity.ok(customerSvc.update(mj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        customerSvc.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}