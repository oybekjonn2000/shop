package net.idrok.shopping.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.shopping.entity.Buyurtma;

import net.idrok.shopping.repository.BuyurtmaRepository;


@Service
public class BuyurtmaService {
    @Autowired
    BuyurtmaRepository buyurtmaRepository;

    public Page<Buyurtma> getAll(String key, Pageable pageable) {
        return buyurtmaRepository.findByNomOrInfoContainingIgnoreCase(key, key, pageable);
    }

    public Buyurtma getById(Long id) {
        return buyurtmaRepository.findById(id).get();
    }

    public Buyurtma create(Buyurtma bm) {
        if (bm.getId() == null)
       return     buyurtmaRepository.save(bm);
        throw new RuntimeException("id null bolishi kerak");
    }

    public Buyurtma update(Buyurtma bm) {
        if (bm.getId() != null)
         return   buyurtmaRepository.save(bm);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(Buyurtma bm) {
        buyurtmaRepository.delete(bm);
    }

    public void deleteById(Long bmId) {
        buyurtmaRepository.deleteById(bmId);
    }
    
}
