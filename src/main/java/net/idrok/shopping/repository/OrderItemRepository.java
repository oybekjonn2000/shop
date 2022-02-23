package net.idrok.shopping.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.idrok.shopping.entity.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    Page<OrderItem> findByProductNameOrOrderNameContainingIgnoreCase(String k1, String k2, Pageable pageable);

}
