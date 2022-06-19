package net.idrok.shopping.service;


import net.idrok.shopping.dto.Purchase;
import net.idrok.shopping.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
