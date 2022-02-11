package net.idrok.shopping.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.idrok.shopping.entity.Tulov;

@Repository
public interface TulovRepository extends JpaRepository<Tulov, Long> {
    Page<Tulov> findByNomOrStatusContainingIgnoreCase(String k1, String k2,  Pageable pageable);

}