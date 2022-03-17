package net.idrok.shopping.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import net.idrok.shopping.entity.Product;
import net.idrok.shopping.repository.ProductRepository;
import net.idrok.shopping.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    public Page<Product> getAll(Pageable pageable,String key) {
        return productRepository.findByNameOrInfoContainingIgnoreCase(key, key, pageable);
    }

    public Product getById(Long id) {
        return productRepository.findById(id).get();
    }

    public Product create(Product m) {
        if (m.getId() == null)
       return     productRepository.save(m);
        throw new RuntimeException("id null bolishi kerak");
    }

    public Product update(Product m) {
        if (m.getId() != null)
         return   productRepository.save(m);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(Product m) {
        productRepository.delete(m);
    }

    public void deleteById(Long mId) {
        productRepository.deleteById(mId);
    }
    
}
