package net.idrok.shopping.dto;

import lombok.Data;
import net.idrok.shopping.entity.Address;
import net.idrok.shopping.entity.Customer;
import net.idrok.shopping.entity.Order;
import net.idrok.shopping.entity.OrderItem;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;

    private Address shippingAddress;

    private Address billingAddress;

    private Order order;

    private Set<OrderItem> orderItems;


}
