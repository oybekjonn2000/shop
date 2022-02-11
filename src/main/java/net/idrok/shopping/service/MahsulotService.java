package net.idrok.shopping.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import net.idrok.shopping.entity.Mahsulot;
import net.idrok.shopping.repository.MahsulotRepository;


@Service
public class MahsulotService {
    @Autowired
    MahsulotRepository mahsulotRepository;

    public Page<Mahsulot> getAll(String key, Pageable pageable) {
        return mahsulotRepository.findByNomOrInfoContainingIgnoreCase(key, key, pageable);
    }

    public Mahsulot getById(Long id) {
        return mahsulotRepository.findById(id).get();
    }

    public Mahsulot create(Mahsulot m) {
        if (m.getId() == null)
       return     mahsulotRepository.save(m);
        throw new RuntimeException("id null bolishi kerak");
    }

    public Mahsulot update(Mahsulot m) {
        if (m.getId() != null)
         return   mahsulotRepository.save(m);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(Mahsulot m) {
        mahsulotRepository.delete(m);
    }

    public void deleteById(Long mId) {
        mahsulotRepository.deleteById(mId);
    }
    
}
