package com.adgwr.online.ordering.system.admin.service.impl;

import com.adgwr.online.ordering.system.admin.service.OrderService;
import com.adgwr.online.ordering.system.domain.*;
import com.adgwr.online.ordering.system.mapper.FoodMapper;
import com.adgwr.online.ordering.system.mapper.LineitemMapper;
import com.adgwr.online.ordering.system.mapper.MyOrderMapper;
import com.adgwr.online.ordering.system.mapper.ReceiverMapper;
import com.adgwr.online.ordering.system.vo.OrderWithReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wyun
 */
@Service
@Transactional(readOnly = false)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MyOrderMapper myOrderMapper;

    @Autowired
    private ReceiverMapper receiverMapper;

    @Autowired
    private LineitemMapper lineitemMapper;

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<OrderWithReceiver> showPaidList(){

        List<MyOrder> orderList = myOrderMapper.selectByState("已付款");
        return getList(orderList);
    }

    @Override
    public List<MyOrder> showFinishedOrderList() {
        return myOrderMapper.selectByState("已完成");
    }

    @Override
    public List<OrderWithReceiver> showReceivedList(){

        List<MyOrder> orderList = myOrderMapper.selectByState("已接单");
        return getList(orderList);
    }

    @Override
    public List<OrderWithReceiver> showDeliveringList(){

        List<MyOrder> orderList = myOrderMapper.selectByState("正在配送");
        return getList(orderList);
    }

    @Override
    public List<OrderWithReceiver> showFinishedList(){

        List<MyOrder> orderList = myOrderMapper.selectByState("已完成");
        return getList(orderList);
    }

    /**
     * 通过orderList来得到最终可以返回Controller的list(String类型)
     * @param orderList
     * @return
     */
    public List<OrderWithReceiver> getList(List<MyOrder> orderList){
        List<OrderWithReceiver> list = new ArrayList<OrderWithReceiver>();
        for (int i = 0; i < orderList.size() ; i++){//遍历每个MyOrder并且把所有需要的属性值全部加到list里面
            OrderWithReceiver ord = new OrderWithReceiver();
            MyOrder m = orderList.get(i);
            int orderId = m.getOrderId();
            ord.setOrderID(orderId);
            ord.setCustomerID(m.getcId());
            ord.setDate(m.getOrderDate());
            ord.setState(m.getOrderState());
            ord.setShipMethod(m.getShipMethod());

            int r_id = m.getrId();

            //通过r_id来查找receiver的相关属性并加到list中
            Example example=new Example(Receiver.class);
            example.createCriteria().andEqualTo("rId",r_id);
            ord.setReceiver(receiverMapper.selectOneByExample(example));


            //通过orderId来查找相应的Lineitem
            Example example1=new Example(Lineitem.class);
            example1.createCriteria().andEqualTo("orderId",orderId);
            List<Lineitem> lineitemList = lineitemMapper.selectByExample(example1);

            //用于存储订单项的信息
            String result = "";
            for(Lineitem l: lineitemList){
                int foodId = l.getFoodId();
                Example example2=new Example(Food.class);
                example2.createCriteria().andEqualTo("foodId",foodId);
                Food food = foodMapper.selectOneByExample(example2);
                result += food.getFdName() + "*" + l.getAmount() + "  ";
            }
            ord.setOrderContent(result);
            list.add(ord);
        }
        return list;
    }

    @Override
    public void receiveOrder(int orderId){
        Example example=new Example(MyOrder.class);
        example.createCriteria().andEqualTo("orderId",orderId);
        MyOrder myOrder = myOrderMapper.selectOneByExample(example);
        myOrder.setOrderState("已接单");
        myOrderMapper.updateByPrimaryKey(myOrder);
    }

    @Override
    public void deliverOrder(int orderId){
        Example example=new Example(MyOrder.class);
        example.createCriteria().andEqualTo("orderId",orderId);
        MyOrder myOrder = myOrderMapper.selectOneByExample(example);
        myOrder.setOrderState("配送中");
        myOrderMapper.updateByPrimaryKey(myOrder);
    }

    @Override
    public MyOrder getOrderById(int orderId) {
        return myOrderMapper.selectByPrimaryKey(orderId);
    }
}
