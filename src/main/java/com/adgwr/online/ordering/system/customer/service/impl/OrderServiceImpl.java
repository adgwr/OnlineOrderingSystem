package com.adgwr.online.ordering.system.customer.service.impl;

import com.adgwr.online.ordering.system.customer.service.OrderService;
import com.adgwr.online.ordering.system.domain.*;
import com.adgwr.online.ordering.system.mapper.*;
import com.adgwr.online.ordering.system.utils.OrderState;
import com.adgwr.online.ordering.system.utils.ShipMethod;
import com.adgwr.online.ordering.system.vo.BalanceItem;
import com.adgwr.online.ordering.system.vo.OrderWithFoodAndReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.sound.sampled.Line;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author LiYuHan
 * @title OrderServiceImpl
 * @description
 * @date 3/7/2019 下午4:38
 */
@Service
@Transactional(readOnly = false)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MyOrderMapper orderMapper;

    @Autowired
    private ReceiverMapper receiverMapper;

    @Autowired
    private LineitemMapper lineitemMapper;

    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private ShoppingcartMapper shoppingcartMapper;

    @Override
    public int newOrder(String cId, Integer rId, String method, List<BalanceItem> balanceItems) {

        // 插入新订单到my_order
        MyOrder myOrder = new MyOrder();
        myOrder.setcId(cId);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        myOrder.setOrderDate(df.format(new Date()));
        myOrder.setrId(rId);
        myOrder.setShipMethod(method);
        myOrder.setOrderState(OrderState.UNPAID.getDec());

        // 获取刚插入的orderId
        orderMapper.insert(myOrder);
        int orderId = myOrder.getOrderId();
        for(BalanceItem b :balanceItems) {
            // 插入lineitem
            Lineitem l = new Lineitem();
            l.setOrderId(orderId);
            l.setAmount(b.getAmount());
            l.setTotalPrice(b.getTotalPrice());
            l.setFoodId(b.getFoodId());
            lineitemMapper.insert(l);
            // 删除shoppingcart
            Shoppingcart s = new Shoppingcart();
            s.setFoodId(b.getFoodId());
            s.setcId(cId);
            shoppingcartMapper.deleteByPrimaryKey(s);

        }
        return orderId;
//        return -1;
    }

    @Override
    public void changeOrderState(int orderId) {
        Example example=new Example(MyOrder.class);
        example.createCriteria().andEqualTo("orderId",orderId);
        //从数据查询
        MyOrder order = orderMapper.selectOneByExample(example);
        switch(order.getOrderState()) {
            case "未付款":
                order.setOrderState(OrderState.PAID.getDec());
                break;
            case "已付款":
                order.setOrderState(OrderState.DELIVERING.getDec());
                break;
            case "正在配送":
                order.setOrderState(OrderState.COMMENT.getDec());
                break;
            case "已接单":
//                order.setOrderState(OrderState.COMMENT.getDec());
                break;
            case "待评价":
                order.setOrderState(OrderState.COMPLETE.getDec());
                break;
            default:
                // Error
                throw new IllegalArgumentException("Unexpected order state!");
        }
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public void cancelOrder(int orderId) {
        Example example=new Example(MyOrder.class);
        example.createCriteria().andEqualTo("orderId",orderId);
        //从数据查询
        MyOrder order = orderMapper.selectOneByExample(example);
        order.setOrderState(OrderState.CANCELED.getDec());
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public List<OrderWithFoodAndReceiver> getOrders(String cId) {
        Example example=new Example(MyOrder.class);
        example.createCriteria().andEqualTo("cId",cId);
        //从数据查询
        List<MyOrder> orders = orderMapper.selectByExample(example);
        List<OrderWithFoodAndReceiver> ordersWithFoodAndReceivers = new ArrayList<>();

        for(MyOrder myOrder : orders) {

            OrderWithFoodAndReceiver o = new OrderWithFoodAndReceiver(myOrder);

            Receiver receiver = new Receiver();
            receiver.setrId(myOrder.getrId());
            receiver = receiverMapper.selectByPrimaryKey(receiver);
            o.setReceiver(receiver.getrName());
            Example example1 = new Example(Lineitem.class);
            example1.createCriteria().andEqualTo("orderId", myOrder.getOrderId());

            List<Lineitem> lineitems = lineitemMapper.selectByExample(example1);
            List<String> foods = new ArrayList<>();
            BigDecimal totalPrice = new BigDecimal("0");

            for(Lineitem l : lineitems) {
                totalPrice = totalPrice.add(l.getTotalPrice());
                Food food = new Food();
                food.setFoodId(l.getFoodId());
                food = foodMapper.selectByPrimaryKey(food);
                String foodStr = food.getFdName() + " × " + l.getAmount();
                foods.add(foodStr);
            }
            o.setPrice(totalPrice);
            o.setFoods(foods);
            ordersWithFoodAndReceivers.add(o);
        }
        java.util.Collections.sort(ordersWithFoodAndReceivers);
        return ordersWithFoodAndReceivers;
    }

    @Override
    public List<BalanceItem> getBalanceItems(String cId, Integer[] foodIds) {

        List<BalanceItem> orderItems = new ArrayList<>();
        for(Integer foodId : foodIds) {
            BalanceItem balanceItem = new BalanceItem(foodMapper.selectByPrimaryKey(foodId));
            Shoppingcart shoppingcart = new Shoppingcart();
            shoppingcart.setcId(cId);
            shoppingcart.setFoodId(foodId);
            shoppingcart = shoppingcartMapper.selectByPrimaryKey(shoppingcart);
            balanceItem.setAmount(shoppingcart.getAmount());
            orderItems.add(balanceItem);
        }
        return orderItems;
    }

    @Override
    public MyOrder getOrderById(int orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public BigDecimal getOrderPrice(int orderId) {
        Example example = new Example(Lineitem.class);
        example.createCriteria().andEqualTo("orderId", orderId);
        List<Lineitem> lineitems = lineitemMapper.selectByExample(example);
        BigDecimal orderPrice = new BigDecimal("0");
        for(Lineitem l : lineitems) {
            orderPrice = orderPrice.add(l.getTotalPrice());
        }
        orderPrice.setScale(2);
        return orderPrice;
    }

}
