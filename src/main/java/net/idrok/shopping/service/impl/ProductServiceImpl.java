package net.idrok.shopping.service.impl;

import net.idrok.shopping.entity.Product;
import net.idrok.shopping.repository.ProductRepository;
import net.idrok.shopping.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;


@Service
@Transactional
 public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> getAll(Pageable pageable, String key) {
        return productRepository.findByNameContainingIgnoreCase(key, pageable);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product create(Product product) {
        if (product.getId() == null){
            product.setDateCreated(LocalDateTime.now());
            product.setLastUpdated(LocalDateTime.now());
            product.setActive(true);
            return  productRepository.save(product);
        }
        throw new RuntimeException("id null bolishi kerak");
    }

    @Override
    public Product update(Product entity) {
        if(entity.getId()!=null)
            return productRepository.save(entity);
        throw  new RuntimeException("id must not be null ");
    }

    @Override
    public void delete(Product entity) {
productRepository.delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
    productRepository.deleteById(entityId);
    }


    @Override
    public Page<Product> getByCategoryId(Long id,  Pageable pageable) {
        return productRepository.findByCategoryId(id,  pageable);
    }

    @Override
    public Page<Product> getByDiscountPercent(Long percent, Pageable pageable) {
        return productRepository.findByDiscountPercent(percent, pageable);
    }


}
