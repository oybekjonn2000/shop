package net.idrok.shopping.controller.admin;

import net.idrok.shopping.entity.ImageModel;
import net.idrok.shopping.entity.Product;
import net.idrok.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProductService productService;

    @PostMapping( value = {"/addNewProduct"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Product addNewProduct(@RequestPart("product") Product product,
                                 @RequestPart("imageFile") MultipartFile[] file ) {


        try {
            Set<ImageModel> images = uploadImage(file);
            product.setProductImages(images);
            return productService.addNewProduct(product);
        } catch (Exception e){
            System.out.println(e.getMessage());
        return null;
        }
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



   }
