package net.idrok.shopping.service.impl;

import net.idrok.shopping.entity.ProductCategory;
import net.idrok.shopping.repository.ProductCategoryRepository;
import net.idrok.shopping.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    public Page<ProductCategory> getAll(Pageable pageable, String name) {
        return productCategoryRepository.findByCategoryName(name, pageable);
    }

    public ProductCategory getById(Long id) {

        return productCategoryRepository.findById(id).get();
    }

    public ProductCategory create(ProductCategory k) {
        if (k.getId() == null)
       return     productCategoryRepository.save(k);
        throw new RuntimeException("id null bolishi kerak");
    }

    public ProductCategory update(ProductCategory k) {
        if (k.getId() != null)
         return   productCategoryRepository.save(k);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(ProductCategory k) {
        productCategoryRepository.delete(k);
    }

    public void deleteById(Long mId) {
        productCategoryRepository.deleteById(mId);
    }
}
