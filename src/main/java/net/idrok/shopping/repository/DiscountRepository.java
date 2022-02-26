package net.idrok.shopping.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.idrok.shopping.entity.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long>{
    Page<Discount> findByNameOrPercentContainingIgnoreCase(String k1, String k2,  Pageable pageable);

}
