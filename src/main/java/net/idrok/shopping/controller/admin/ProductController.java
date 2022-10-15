package net.idrok.shopping.controller.admin;

import net.idrok.shopping.entity.ImageModel;
import net.idrok.shopping.entity.Product;
import net.idrok.shopping.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/products")
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

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Product> create(@RequestPart("product") Product product,
                                          @RequestPart("imageFile")MultipartFile[] file) {



        try {
            Set<ImageModel> images = uploadImage(file);
            product.setProductImages(images);
            return ResponseEntity.ok(productService.create(product));
        } catch (Exception e){
            System.out.println(e.getMessage());
        return null;
        }
    }

    @PutMapping()
    public ResponseEntity<Product> update(@RequestBody Product bm) {
        return ResponseEntity.ok(productService.update(bm));
    }

    public Set<ImageModel> uploadImage (MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels = new HashSet<>();
        for(MultipartFile file: multipartFiles){
            ImageModel imageModel = new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
               imageModels.add(imageModel);
        }
        return imageModels;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //get by category id
    @GetMapping("/findByCategoryId")
    public ResponseEntity<Page<Product>> getByCategoryId(@RequestParam(name="id", required = false)   Long id, Pageable pageable){
        return ResponseEntity.ok(productService.getByCategoryId(id,  pageable));
    }

    //get by discounts percent
    @GetMapping("/findByDiscountPercent")
    public ResponseEntity<Page<Product>> getByDiscountPercent(@RequestParam(name="percent", required = false)   String percent, Pageable pageable){
        return ResponseEntity.ok(productService.getByDiscountPercent(percent,  pageable));
    }


}
