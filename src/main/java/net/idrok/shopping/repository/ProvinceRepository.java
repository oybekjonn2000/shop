package net.idrok.shopping.repository;

import net.idrok.shopping.entity.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
Page<Province> findAllByNameContainingIgnoreCase(String k1,  Pageable pageable);

}