package net.idrok.shopping.repository;

import net.idrok.shopping.entity.Order_Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order_Item_Repository extends JpaRepository<Order_Item, Long> {

    Page<Order_Item> findByImageUrl(String k1, Pageable pageable);
}
