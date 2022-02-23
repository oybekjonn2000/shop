package net.idrok.shopping.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.shopping.entity.Order;

import net.idrok.shopping.repository.OrderRepository;


@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Page<Order> getAll(String key, Pageable pageable) {
        return orderRepository.findByNameOrInfoContainingIgnoreCase(key, key, pageable);
    }

    public Order getById(Long id) {
        return orderRepository.findById(id).get();
    }

    public Order create(Order bm) {
        if (bm.getId() == null)
       return     orderRepository.save(bm);
        throw new RuntimeException("id null bolishi kerak");
    }

    public Order update(Order bm) {
        if (bm.getId() != null)
         return   orderRepository.save(bm);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(Order bm) {
        orderRepository.delete(bm);
    }

    public void deleteById(Long bmId) {
        orderRepository.deleteById(bmId);
    }
    
}
