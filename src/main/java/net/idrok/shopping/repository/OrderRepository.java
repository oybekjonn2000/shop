package net.idrok.shopping.entity.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.idrok.shopping.entity.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findByNameOrInfoContainingIgnoreCase(String k1, String k2, Pageable pageable);

}
