package com.adgwr.online.ordering.system.vo;

import com.adgwr.online.ordering.system.domain.MyOrder;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 本类保存了订单及相应的菜品及收货人信息
 *
 * @author lyc
 * @version 1.0
 */
public class OrderWithFoodAndReceiver implements Comparable<OrderWithFoodAndReceiver> {

    /**
     * 订单id
     */
    private int orderId;

    /**
     * 菜品列表
     */
    private List<String> foods;

    /**
     * 订单价格
     */
    private BigDecimal price;

    /**
     * 订单日期
     */
    private String date;

    /**
     * 收货人信息
     */
    private String receiver;

    /**
     * 配送方式
     */
    private String shipment;

    /**
     * 订单状态
     */
    private String state;


    /**
     * 初始化实例
     *
     * @param myOrder 订单MyOrder
     */
    public OrderWithFoodAndReceiver(MyOrder myOrder) {
        this.orderId = myOrder.getOrderId();
        this.date = myOrder.getOrderDate();
        this.shipment = myOrder.getShipMethod();
        this.state = myOrder.getOrderState();
    }

    /**
     * 返回订单id
     *
     * @return orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * 返回菜品列表
     *
     * @return foods
     */
    public List<String> getFoods() {
        return foods;
    }

    /**
     * 设置菜品列表
     *
     * @param foods
     */
    public void setFoods(List<String> foods) {
        this.foods = foods;
    }

    /**
     * 返回订单价格
     *
     * @return foods
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置订单价格
     *
     * @param price 订单价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
        this.price.setScale(2);
    }

    /**
     * 返回订单日期
     *
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * 设置订单日期
     *
     * @param date 订单日期
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 返回收货人
     *
     * @return receiver
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * 设置收货人
     *
     * @param receiver 收货人
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * 返回配送方式
     *
     * @return shipment
     */
    public String getShipment() {
        return shipment;
    }

    /**
     * 设置配送方式
     *
     * @param shipment 配送方式
     */
    public void setShipment(String shipment) {
        this.shipment = shipment;
    }

    /**
     * 返回订单状态
     *
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * 设置订单状态
     *
     * @param state 订单状态
     */
    public void setState(String state) {
        this.state = state;
    }


    @Override
    public int compareTo(OrderWithFoodAndReceiver o) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date thisOne = df.parse(this.getDate());
            Date that = df.parse(o.getDate());
            if (thisOne.after(that)) {
                return -1;
            } else if (thisOne.before(that)) {
                return 1;
            } else {
                return 0;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
