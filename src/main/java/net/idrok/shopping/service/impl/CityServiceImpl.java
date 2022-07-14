package net.idrok.shopping.service.impl;

import net.idrok.shopping.entity.City;
import net.idrok.shopping.repository.CityRepository;
import net.idrok.shopping.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;

    @Override
    public Page<City> getAll(Pageable pageable, String key) {
        return cityRepository.findByNameContainingIgnoreCase(key, pageable);
    }

    @Override
    public City getById(Long id) {
        return cityRepository.findById(id).get();
    }

    @Override
    public City create(City entity) {
        if(entity.getId()==null)
            return cityRepository.save(entity);
        throw  new RuntimeException("id must be null");
    }

    @Override
    public City update(City entity) {
        if(entity.getId()!=null)
            return cityRepository.save(entity);
        throw  new RuntimeException("id must be null");
    }

    @Override
    public void delete(City entity) {
        cityRepository.delete(entity);

    }

    @Override
    public void deleteById(Long entityId) {
        cityRepository.deleteById(entityId);
    }

    @Override
    public Page<City> findByProvinceCode(String code, Pageable pageable) {
        return cityRepository.findByProvinceCode(code, pageable);
    }
}
