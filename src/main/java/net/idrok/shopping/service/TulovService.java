package net.idrok.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.shopping.entity.Tulov;

import net.idrok.shopping.repository.TulovRepository;

@Service
public class TulovService {

    @Autowired
    TulovRepository tr;

    public Page<Tulov> getAll(String key, Pageable pageable) {
        return tr.findByNomOrStatusContainingIgnoreCase(key, key, pageable);
    }

    public Tulov getById(Long id) {
        return tr.findById(id).get();
    }

    public Tulov create(Tulov t) {
        if (t.getId() == null)
            return tr.save(t);
        throw new RuntimeException("id null bolishi kerak");
    }

    public Tulov update(Tulov t) {
        if (t.getId() != null)
            return tr.save(t);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(Tulov t) {
        tr.delete(t);
    }

    public void deleteById(Long mjId) {
        tr.deleteById(mjId);
    }

}