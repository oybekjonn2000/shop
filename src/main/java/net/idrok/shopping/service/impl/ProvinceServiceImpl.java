package net.idrok.shopping.service.impl;

import net.idrok.shopping.entity.Province;
import net.idrok.shopping.repository.ProvinceRepository;
import net.idrok.shopping.service.ProvinceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    private final ProvinceRepository provinceRepository;

    public ProvinceServiceImpl(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @Override
    public Page<Province> getAll(Pageable pageable, String key) {
        return provinceRepository.findByCode(key, pageable);
    }

    @Override
    public Province getById(Long id) {
        return provinceRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public Province create(Province entity) {
        if(entity.getId()==null)
            return provinceRepository.save(entity);
            throw  new RuntimeException("id must be null");
    }

    @Override
    public Province update(Province entity) {
        if(entity.getId()!=null)
            return provinceRepository.save(entity);
        throw  new RuntimeException("id must be null");
    }

    @Override
    public void delete(Province entity) {
    provinceRepository.delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        provinceRepository.deleteById(entityId);

    }

    // READY FOR RUNNING
}
