package com.adgwr.online.ordering.system.vo;

import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.domain.Lineitem;
import com.adgwr.online.ordering.system.domain.Receiver;

import java.util.ArrayList;

public class OrderWithReceiver {
    private int orderID;
    private String customerID;
    private int receiverID;
    private Receiver receiver;
    private String date;
    private String state;
    private String shipMethod;
    private String orderContent;

    public int getOrderID() {
        return orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public int getReceiverID() {
        return receiverID;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public String getDate() {
        return date;
    }

    public String getState() {
        return state;
    }

    public String getShipMethod() {
        return shipMethod;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setShipMethod(String shipMethod) {
        this.shipMethod = shipMethod;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }
}
