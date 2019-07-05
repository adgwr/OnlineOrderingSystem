package com.adgwr.online.ordering.system.vo;

import com.adgwr.online.ordering.system.domain.MyOrder;

import java.math.BigDecimal;
import java.util.List;

public class OrderWithFoodAndReceiver {

    private int orderId;
    private List<String> foods;
    private BigDecimal price;
    private String date;
    private String receiver;
    private String shipment;
    private String state;

    public OrderWithFoodAndReceiver(MyOrder myOrder) {
        this.orderId = myOrder.getOrderId();
        this.date = myOrder.getOrderDate();
        this.shipment = myOrder.getShipMethod();
        this.state = myOrder.getOrderState();
    }

    public OrderWithFoodAndReceiver(int orderId, List<String> foods, BigDecimal price, String date, String receiver, String shipment, String state) {
        this.orderId = orderId;
        this.foods = foods;
        this.price = price;
        this.price.setScale(2);
        this.date = date;
        this.receiver = receiver;
        this.shipment = shipment;
        this.state = state;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<String> getFoods() {
        return foods;
    }

    public void setFoods(List<String> foods) {
        this.foods = foods;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
        this.price.setScale(2);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getShipment() {
        return shipment;
    }

    public void setShipment(String shipment) {
        this.shipment = shipment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
