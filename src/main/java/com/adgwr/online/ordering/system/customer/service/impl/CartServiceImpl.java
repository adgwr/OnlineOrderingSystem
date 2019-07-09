package com.adgwr.online.ordering.system.customer.service.impl;

import com.adgwr.online.ordering.system.customer.service.CartService;
import com.adgwr.online.ordering.system.domain.*;
import com.adgwr.online.ordering.system.mapper.FoodMapper;
import com.adgwr.online.ordering.system.mapper.LineitemMapper;
import com.adgwr.online.ordering.system.mapper.MyOrderMapper;
import com.adgwr.online.ordering.system.mapper.ShoppingcartMapper;
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
    private ShoppingcartMapper shoppingcartMapper;

    @Autowired
    private MyOrderMapper myOrderMapper;

    @Override
    public List<Lineitem> getLineitem(List<Integer> orderIds) {
        Example example=new Example(Shoppingcart.class);
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
    public List<Shoppingcart> getShoppingcart(String cId) {
        Example example = new Example(Shoppingcart.class);
        example.createCriteria().andEqualTo("cId",cId);
        return shoppingcartMapper.selectByExample(example);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateShoppingcart(Shoppingcart newShoppingcart, Shoppingcart oldShoppingcart) {
        Example example = new Example(Shoppingcart.class);
        example.createCriteria().andEqualTo("cId",oldShoppingcart.getcId()).andEqualTo("foodId",oldShoppingcart.getFoodId());
        shoppingcartMapper.updateByExample(newShoppingcart,example);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteShoppingcart(List<Integer> foodIds, String cId) {

        for (Integer foodId : foodIds) {
            Example example = new Example(Shoppingcart.class);
            example.createCriteria().andEqualTo("cId", cId).andEqualTo("foodId",foodId);
            shoppingcartMapper.deleteByExample(example);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void addShoppingcart(String cId, int foodId) {
        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.setcId(cId);
        shoppingcart.setFoodId(foodId);
        Shoppingcart sc = shoppingcartMapper.selectByPrimaryKey(shoppingcart);
        if(sc != null && sc.getAmount() != null) {
            shoppingcart.setAmount(sc.getAmount() + 1);
            shoppingcartMapper.updateByPrimaryKey(shoppingcart);
        }
        else {
            shoppingcart.setAmount(1);
            shoppingcartMapper.insert(shoppingcart);
        }

    }
}
