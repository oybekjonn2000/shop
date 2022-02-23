package net.idrok.shopping.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.shopping.entity.Brand;
import net.idrok.shopping.repository.BrandRepository;


@Service
public class BrandService {
    @Autowired
    BrandRepository brandRepository;

    public Page<Brand> getAll(String key, Pageable pageable) {
        return brandRepository.findByNameOrInfoContainingIgnoreCase(key, key, pageable);
    }

    public Brand getById(Long id) {
        return brandRepository.findById(id).get();
    }

    public Brand create(Brand k) {
        if (k.getId() == null)
       return     brandRepository.save(k);
        throw new RuntimeException("id null bolishi kerak");
    }

    public Brand update(Brand k) {
        if (k.getId() != null)
         return   brandRepository.save(k);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(Brand k) {
        brandRepository.delete(k);
    }

    public void deleteById(Long mId) {
        brandRepository.deleteById(mId);
    }
}
