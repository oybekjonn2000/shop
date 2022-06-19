package net.idrok.shopping.service.impl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.shopping.entity.Brand;
import net.idrok.shopping.repository.BrandRepository;
import net.idrok.shopping.service.BrandService;


@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    public Page<Brand> getAll(Pageable pageable, String key) {
        return brandRepository.findByNameContainingIgnoreCase(key, pageable);
    }

    @Override
    public Brand getById(Long id) {
        return brandRepository.findById(id).get();
    }

    @Override
    public Brand create(Brand entity) {
        if(entity.getId()==null)
        return brandRepository.save(entity);
        throw  new RuntimeException("id must be null");
    }

    @Override
    public Brand update(Brand entity) {
        if(entity.getId()!=null)
        return brandRepository.save(entity);
        throw  new RuntimeException("id must not be null ");
    }

    @Override
    public void delete(Brand entity) {
    brandRepository.delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
    brandRepository.deleteById(entityId);
    }

    //READY
}
