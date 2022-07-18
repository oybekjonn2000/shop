package net.idrok.shopping.service;

import net.idrok.shopping.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface OrderService extends CommonService<Order> {

    Page<Order> findByCustomerEmailOrderByDateCreatedDesc( String email, Pageable pageable);

}
