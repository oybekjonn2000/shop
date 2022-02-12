package net.idrok.shopping.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.shopping.entity.BuyurtmaMahsulot;

import net.idrok.shopping.repository.BuyurtmaMahsulotRepository;

//commit qoshildi
@Service
public class BuyurtmaMahsulotService {
    @Autowired
    BuyurtmaMahsulotRepository buyurtmaMahsulotRepository;

    public Page<BuyurtmaMahsulot> getAll(String key, Pageable pageable) {
        return buyurtmaMahsulotRepository.findByMahsulotNomOrBuyurtmaNomContainingIgnoreCase(key, key, pageable);
    }

    public BuyurtmaMahsulot getById(Long id) {
        return buyurtmaMahsulotRepository.findById(id).get();
    }

    public BuyurtmaMahsulot create(BuyurtmaMahsulot bm) {
        if (bm.getId() == null)
       return     buyurtmaMahsulotRepository.save(bm);
        throw new RuntimeException("id null bolishi kerak");
    }

    public BuyurtmaMahsulot update(BuyurtmaMahsulot bm) {
        if (bm.getId() != null)
         return   buyurtmaMahsulotRepository.save(bm);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(BuyurtmaMahsulot bm) {
        buyurtmaMahsulotRepository.delete(bm);
    }

    public void deleteById(Long bmId) {
        buyurtmaMahsulotRepository.deleteById(bmId);
    }
    
}
