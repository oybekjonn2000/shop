package net.idrok.shopping.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.shopping.entity.Mijoz;
import net.idrok.shopping.repository.MijozRepository;

@Service
public class MijozService {

    @Autowired
    MijozRepository userRepo;

    public Page<Mijoz> getAll(String key, Pageable pageable) {
        return userRepo.findAllByIsmOrFamiliyaContainingIgnoreCase(key, key, pageable);
    }

    public Mijoz getById(Long id) {
        return userRepo.findById(id).get();
    }

    public Mijoz create(Mijoz mj) {
        if (mj.getId() == null)
       return     userRepo.save(mj);
        throw new RuntimeException("id null bolishi kerak");
    }

    public Mijoz update(Mijoz mj) {
        if (mj.getId() != null)
         return   userRepo.save(mj);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(Mijoz mj) {
        userRepo.delete(mj);
    }

    public void deleteById(Long mjId) {
        userRepo.deleteById(mjId);
    }

}