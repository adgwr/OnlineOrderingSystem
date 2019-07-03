package com.adgwr.online.ordering.system.domain;

import javax.persistence.*;

@Table(name = "my_order")
public class MyOrder {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer orderId;

    @Column(name = "c_id")
    private String cId;

    @Column(name = "r_id")
    private Integer rId;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "order_state")
    private String orderState;

    @Column(name = "ship_method")
    private String shipMethod;

    /**
     * @return order_id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * @return c_id
     */
    public String getcId() {
        return cId;
    }

    /**
     * @param cId
     */
    public void setcId(String cId) {
        this.cId = cId;
    }

    /**
     * @return r_id
     */
    public Integer getrId() {
        return rId;
    }

    /**
     * @param rId
     */
    public void setrId(Integer rId) {
        this.rId = rId;
    }

    /**
     * @return order_date
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return order_state
     */
    public String getOrderState() {
        return orderState;
    }

    /**
     * @param orderState
     */
    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    /**
     * @return ship_method
     */
    public String getShipMethod() {
        return shipMethod;
    }

    /**
     * @param shipMethod
     */
    public void setShipMethod(String shipMethod) {
        this.shipMethod = shipMethod;
    }
}