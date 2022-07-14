package net.idrok.shopping.service;

import net.idrok.shopping.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService extends CommonService<City> {
    Page<City> findByProvinceCode(String code, Pageable pageable);
}
