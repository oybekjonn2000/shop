package net.idrok.shopping.controller.admin;

import net.idrok.shopping.entity.ProductCategory;
import net.idrok.shopping.service.ProductCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/category")
@CrossOrigin(maxAge = 3600)
public class ProductCategoryController {
    private final
    ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping()
    public ResponseEntity<Page<ProductCategory>> getAll(@RequestParam(value = "key", required = false) String key,  Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(productCategoryService.getAll(pageable, key));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> getById(@PathVariable Long id){
        return ResponseEntity.ok(productCategoryService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<ProductCategory> create(@RequestBody ProductCategory kt){
        return ResponseEntity.ok( productCategoryService.create(kt));
    }

    @PutMapping()
    public ResponseEntity<ProductCategory> update(@RequestBody ProductCategory kt){
        return ResponseEntity.ok(productCategoryService.update(kt));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        productCategoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    
    
}
