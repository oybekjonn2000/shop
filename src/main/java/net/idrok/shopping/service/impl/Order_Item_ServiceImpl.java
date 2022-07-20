package net.idrok.shopping.service.impl;


import net.idrok.shopping.entity.Order_Item;
import net.idrok.shopping.repository.Order_Item_Repository;
import net.idrok.shopping.service.Order_Item_Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class Order_Item_ServiceImpl implements Order_Item_Service {

  private final Order_Item_Repository orderItemRepository;

    public Order_Item_ServiceImpl(Order_Item_Repository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public Page<Order_Item> getAll(Pageable pageable, String key) {
        return orderItemRepository.findByImageUrl(key,pageable);
    }

    public Order_Item getById(Long id) {
        return orderItemRepository.findById(id).get();
    }

    public Order_Item create(Order_Item bm) {
        if (bm.getId() == null)
       return     orderItemRepository.save(bm);
        throw new RuntimeException("id null bolishi kerak");
    }

    public Order_Item update(Order_Item bm) {
        if (bm.getId() != null)
         return   orderItemRepository.save(bm);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(Order_Item bm) {
        orderItemRepository.delete(bm);
    }

    public void deleteById(Long bmId) {
        orderItemRepository.deleteById(bmId);
    }
    
}
