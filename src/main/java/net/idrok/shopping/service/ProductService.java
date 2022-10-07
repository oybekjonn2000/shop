package net.idrok.shopping.service;

import net.idrok.shopping.entity.Product;
import net.idrok.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService  {
    @Autowired
    private ProductRepository productRepository;

    public Product addNewProduct(Product product){
        return productRepository.save(product);


    }
//    Page<Product> getByCategoryId(Long id,  Pageable pageable);
//    Page<Product> getByDiscountPercent(String percent,  Pageable pageable);
}
