package net.idrok.shopping.service.impl;


import net.idrok.shopping.entity.Order;
import net.idrok.shopping.repository.OrderRepository;
import net.idrok.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository orderRepository;

    public Page<Order> getAll(Pageable pageable, String key) {
        return orderRepository.findByOrderTrackingNumberContainingIgnoreCase(key, pageable);
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

    @Override
    public Page<Order> findByCustomerEmailOrderByDateCreatedDesc(String email, Pageable pageable) {
        return orderRepository.findByCustomerEmailOrderByDateCreatedDesc(email, pageable);
    }
}
