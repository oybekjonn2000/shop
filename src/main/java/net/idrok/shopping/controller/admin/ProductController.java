package net.idrok.shopping.controller.admin;

import net.idrok.shopping.entity.Product;
import net.idrok.shopping.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/product")
@CrossOrigin(maxAge = 3600)

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping()
    public ResponseEntity<Page<Product>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(productService.getAll(pageable, key));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<Product> create(@RequestBody Product bm) {
        return ResponseEntity.ok(productService.create(bm));
    }

    @PutMapping()
    public ResponseEntity<Product> update(@RequestBody Product bm) {
        return ResponseEntity.ok(productService.update(bm));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
