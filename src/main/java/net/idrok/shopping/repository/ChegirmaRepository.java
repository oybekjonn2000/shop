package net.idrok.shopping.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.idrok.shopping.entity.Chegirma;

public interface ChegirmaRepository extends JpaRepository<Chegirma, Long>{
    Page<Chegirma> findByFoizOrNomContainingIgnoreCase(String k1, String k2, Pageable pageable);

}
