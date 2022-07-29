package net.idrok.shopping.service.impl;

import net.idrok.shopping.entity.Discount;
import net.idrok.shopping.repository.DiscountRepository;
import net.idrok.shopping.service.DiscountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService{


    

   private final DiscountRepository discountRepository;

    public DiscountServiceImpl(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }


    public Page<Discount> getAll(Pageable pageable, String key) {
        return discountRepository.findByNameContainingIgnoreCase(key,  pageable);
    }

    public Discount getById(Long id) {
        return discountRepository.findById(id).get();
    }

    public Discount create(Discount ch) {
        if (ch.getId() == null)
       return     discountRepository.save(ch);
        throw new RuntimeException("id null bolishi kerak");
    }

    public Discount update(Discount ch) {
        if (ch.getId() != null)
         return   discountRepository.save(ch);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(Discount ch) {
        discountRepository.delete(ch);
    }

    public void deleteById(Long chId) {
        discountRepository.deleteById(chId);
    }
    
}
