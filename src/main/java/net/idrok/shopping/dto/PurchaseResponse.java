package net.idrok.shopping.dto;



public class PurchaseResponse {


    private final String orderTrackingNumber;


    public PurchaseResponse(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }
}
