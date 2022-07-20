package net.idrok.shopping.dto;


import net.idrok.shopping.entity.Address;
import net.idrok.shopping.entity.Customer;
import net.idrok.shopping.entity.Order;
import net.idrok.shopping.entity.Order_Item;

import java.util.Set;


public class Purchase {

    private Customer customer;

    private Address shippingAddress;

    private Address billingAddress;

    private Order order;

    private Set<Order_Item> orderItems;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Set<Order_Item> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<Order_Item> orderItems) {
        this.orderItems = orderItems;
    }
}
