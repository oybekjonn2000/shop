package net.idrok.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.shopping.entity.Type;
import net.idrok.shopping.repository.TypeRepository;

@Service


public class TypeService {
    
    @Autowired
    TypeRepository typeREPO;

    public Page<Type> getAll(String key, Pageable pageable) {
        return typeREPO.findByNameContainingIgnoreCase(key, pageable);
    }

    public Type getById(Long id) {
        return typeREPO.findById(id).get();
    }

    public Type create(Type t) {
        if (t.getId() == null)
            return typeREPO.save(t);
        throw new RuntimeException("id null bolishi kerak");
    }

    public Type update(Type t) {
        if (t.getId() != null)
            return typeREPO.save(t);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(Type t) {
        typeREPO.delete(t);
    }

    public void deleteById(Long mjId) {
        typeREPO.deleteById(mjId);
    }
}
