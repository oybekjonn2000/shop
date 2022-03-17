package net.idrok.shopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.shopping.entity.Type;
import net.idrok.shopping.repository.TypeRepository;

@Service


public class TypeServiceImpl {
    
    @Autowired
    TypeRepository typeRepository;

    public Page<Type> getAll(String key, Pageable pageable) {
        return typeRepository.findByNameOrInfoContainingIgnoreCase(key,key, pageable);
    }

    public Type getById(Long id) {
        return typeRepository.findById(id).get();
    }

    public Type create(Type t) {
        if (t.getId() == null)
            return typeRepository.save(t);
        throw new RuntimeException("id null bolishi kerak");
    }

    public Type update(Type t) {
        if (t.getId() != null)
            return typeRepository.save(t);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(Type t) {
        typeRepository.delete(t);
    }

    public void deleteById(Long mjId) {
        typeRepository.deleteById(mjId);
    }
}
