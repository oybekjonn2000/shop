package net.idrok.shopping.service.impl;


import net.idrok.shopping.entity.OrderItem;
import net.idrok.shopping.repository.OrderItemRepository;
import net.idrok.shopping.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemRepository orderItemRepository;

    public Page<OrderItem> getAll(Pageable pageable, String key) {
        return (Page<OrderItem>) orderItemRepository.findAll();
    }

    public OrderItem getById(Long id) {
        return orderItemRepository.findById(id).get();
    }

    public OrderItem create(OrderItem bm) {
        if (bm.getId() == null)
       return     orderItemRepository.save(bm);
        throw new RuntimeException("id null bolishi kerak");
    }

    public OrderItem update(OrderItem bm) {
        if (bm.getId() != null)
         return   orderItemRepository.save(bm);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(OrderItem bm) {
        orderItemRepository.delete(bm);
    }

    public void deleteById(Long bmId) {
        orderItemRepository.deleteById(bmId);
    }
    
}
