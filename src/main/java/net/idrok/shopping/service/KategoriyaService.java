package net.idrok.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.shopping.entity.Kategoriya;
import net.idrok.shopping.repository.KategoriyaRepository;

@Service
public class KategoriyaService {
    @Autowired
    KategoriyaRepository kategoriyaREPO;

    public Page<Kategoriya> getAll(String key, Pageable pageable) {
        return kategoriyaREPO.findByNomOrInfoContainingIgnoreCase(key, key, pageable);
    }

    public Kategoriya getById(Long id) {
        return kategoriyaREPO.findById(id).get();
    }

    public Kategoriya create(Kategoriya k) {
        if (k.getId() == null)
       return     kategoriyaREPO.save(k);
        throw new RuntimeException("id null bolishi kerak");
    }

    public Kategoriya update(Kategoriya k) {
        if (k.getId() != null)
         return   kategoriyaREPO.save(k);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(Kategoriya k) {
        kategoriyaREPO.delete(k);
    }

    public void deleteById(Long mId) {
        kategoriyaREPO.deleteById(mId);
    }
}
