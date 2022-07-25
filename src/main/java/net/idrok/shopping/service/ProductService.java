package net.idrok.shopping.service;

import net.idrok.shopping.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService extends CommonService<Product> {


    Page<Product> getByCategoryId(Long id,  Pageable pageable);
    Page<Product> getByDiscountPercent(String percent,  Pageable pageable);
}
