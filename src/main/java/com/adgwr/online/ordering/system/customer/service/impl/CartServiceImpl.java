package com.adgwr.online.ordering.system.customer.service.impl;

import com.adgwr.online.ordering.system.customer.service.CartService;
import com.adgwr.online.ordering.system.domain.Customer;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.domain.Lineitem;
import com.adgwr.online.ordering.system.domain.MyOrder;
import com.adgwr.online.ordering.system.mapper.FoodMapper;
import com.adgwr.online.ordering.system.mapper.LineitemMapper;
import com.adgwr.online.ordering.system.mapper.MyOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@Service
@Transactional(readOnly = true)
public class CartServiceImpl implements CartService {

    @Autowired
    private LineitemMapper lineitemMapper;

    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private MyOrderMapper myOrderMapper;

    @Override
    public List<Lineitem> getLineitem(List<Integer> orderIds) {
        Example example=new Example(Lineitem.class);
        Example.Criteria criteria = example.createCriteria();
        for (Integer orderId : orderIds) {
            criteria.orEqualTo("orderId",orderId);
        }
        return lineitemMapper.selectByExample(example);
    }

    @Override
    public Food getFoodByFoodId(Integer foodId) {
        Example example=new Example(Food.class);
        example.createCriteria().andEqualTo("foodId",foodId);
        return foodMapper.selectOneByExample(example);
    }

    @Override
    public List<Integer> getOrderIdByCId(String cId) {
        Example example=new Example(MyOrder.class);
        example.createCriteria().andEqualTo("cId",cId);
        List<MyOrder> myOrders = myOrderMapper.selectByExample(example);

        List<Integer> orderIds=new ArrayList<>();
        for (MyOrder myOrder : myOrders) {
            orderIds.add(myOrder.getOrderId());
        }
        return orderIds;
    }

    @Override
    @Transactional(readOnly = false)
    public void updateLineitem(Lineitem lineitem,Lineitem newLineitem) {
        Example example = new Example(Lineitem.class);
        example.createCriteria().
                andEqualTo("orderId",lineitem.getOrderId()).
                andEqualTo("foodId",lineitem.getFoodId());
        lineitemMapper.updateByExample(newLineitem,example);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteLineitem(List<Integer> item, Customer customer) {
        List<Integer> orderIdByCId = getOrderIdByCId(customer.getcId());
        List<Lineitem> lineitem = getLineitem(orderIdByCId);
        List<Lineitem> toRemove=new ArrayList<>();

        for (Integer integer : item) {
            for (Lineitem lineitem1 : lineitem) {
                if(integer.equals(lineitem1.getFoodId())){
                    toRemove.add(lineitem1);
                }
            }
        }

        for (Lineitem li : toRemove) {
            Example example = new Example(Lineitem.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("orderId",li.getOrderId()).andEqualTo("foodId",li.getFoodId());
            lineitemMapper.deleteByExample(example);
        }
    }
}
