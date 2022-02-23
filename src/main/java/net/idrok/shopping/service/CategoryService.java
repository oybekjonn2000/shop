package net.idrok.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.shopping.entity.Category;
import net.idrok.shopping.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Page<Category> getAll(String key, Pageable pageable) {
        return categoryRepository.findByNameOrInfoContainingIgnoreCase(key, key, pageable);
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id).get();
    }

    public Category create(Category k) {
        if (k.getId() == null)
       return     categoryRepository.save(k);
        throw new RuntimeException("id null bolishi kerak");
    }

    public Category update(Category k) {
        if (k.getId() != null)
         return   categoryRepository.save(k);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(Category k) {
        categoryRepository.delete(k);
    }

    public void deleteById(Long mId) {
        categoryRepository.deleteById(mId);
    }
}
