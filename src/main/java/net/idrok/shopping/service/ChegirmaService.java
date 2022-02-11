package net.idrok.shopping.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import net.idrok.shopping.entity.Chegirma;
import net.idrok.shopping.repository.ChegirmaRepository;

@Service
public class ChegirmaService {


    
    @Autowired
    ChegirmaRepository chr;

    public Page<Chegirma> getAll(String key, Pageable pageable) {
        return chr.findByFoizOrNomContainingIgnoreCase (key, key,  pageable);
    }

    public Chegirma getById(Long id) {
        return chr.findById(id).get();
    }

    public Chegirma create(Chegirma ch) {
        if (ch.getId() == null)
       return     chr.save(ch);
        throw new RuntimeException("id null bolishi kerak");
    }

    public Chegirma update(Chegirma ch) {
        if (ch.getId() != null)
         return   chr.save(ch);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(Chegirma ch) {
        chr.delete(ch);
    }

    public void deleteById(Long chId) {
        chr.deleteById(chId);
    }
    
}
