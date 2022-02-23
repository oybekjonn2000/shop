package net.idrok.shopping.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import net.idrok.shopping.entity.Discount;
import net.idrok.shopping.repository.DiscountRepository;

@Service
public class DiscountService {


    
    @Autowired
    DiscountRepository discountRepository;

    public Page<Discount> getAll(String key, Pageable pageable) {
        return discountRepository.findByNameOrPercentContainingIgnoreCase(key, key,  pageable);
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
