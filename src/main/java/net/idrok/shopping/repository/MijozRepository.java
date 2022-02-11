package net.idrok.shopping.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.idrok.shopping.entity.Mijoz;

@Repository
public interface MijozRepository extends JpaRepository<Mijoz, Long> {
    Page<Mijoz> findAllByUsernameOrPasswordContainingIgnoreCase(String k1, String k2, Pageable pageable);

}