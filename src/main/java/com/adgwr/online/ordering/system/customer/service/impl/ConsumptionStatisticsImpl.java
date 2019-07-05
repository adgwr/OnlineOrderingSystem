package com.adgwr.online.ordering.system.customer.service.impl;

import com.adgwr.online.ordering.system.customer.service.ConsumptionStatisticsService;
import com.adgwr.online.ordering.system.domain.MyOrder;
import com.adgwr.online.ordering.system.domain.Lineitem;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.mapper.LineitemMapper;
import com.adgwr.online.ordering.system.mapper.MyOrderMapper;
import com.adgwr.online.ordering.system.mapper.FoodMapper;
import com.adgwr.online.ordering.system.vo.CustumerConsumption;
import com.adgwr.online.ordering.system.utils.OrderState;
import com.adgwr.online.ordering.system.utils.ShipMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.math.BigDecimal;

@Service
@Transactional(readOnly = false)
public class ConsumptionStatisticsImpl implements ConsumptionStatisticsService{

    @Autowired
    private MyOrderMapper orderMapper;

    @Autowired
    private LineitemMapper lineitemMapper;

    @Autowired
    private FoodMapper foodMapper;

    public boolean isInDate(String dt, String dt1, String dt2) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = df.parse(dt);
            Date date1 = df.parse(dt1);
            Date date2 = df.parse(dt2);
            return date.compareTo(date1) >= 0 && date.compareTo(date2) <= 0;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Integer> getOrderListThisMonth(){
        Example OrderEx = new Example(MyOrder.class);

        Example.Criteria c = OrderEx.createCriteria();
        c.andEqualTo("order_state", "已完成");
//        OrderEx.createCriteria().andEqualTo("order_state", "已完成");
        List<MyOrder> orders = orderMapper.selectByExample(OrderEx);

        int orderid;
        List<Integer> orderIdList= new ArrayList<>();;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();// 获取当前日期
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        String firstDay = df.format(cal.getTime());
        firstDay = firstDay + " 00:00:00";// startDate
        String nowDate = df2.format(new Date());// endDate
        String sqldate ;

        for(MyOrder order : orders) {
            sqldate = order.getOrderDate();
            if (isInDate(sqldate, firstDay, nowDate)) {
                orderid = order.getrId();
                orderIdList.add(orderid);
            }
        }
        return orderIdList;
    }

    public List<CustumerConsumption> getCustumerConsumptionList(List<Integer> orderIdList){
        int foodid;
        String foodname = "";
        BigDecimal price ;
        double dprice =0.0;
        int isexist = 0;
        List<CustumerConsumption> CustumerConsumptionlist = new ArrayList<>();
        for(int orderId : orderIdList){
            Example lineItemEx = new Example(Lineitem.class);
            lineItemEx.createCriteria().andEqualTo("orderId", orderId);
            List<Lineitem> lineitems = lineitemMapper.selectByExample(lineItemEx);
            for(Lineitem item : lineitems){
                foodid = item.getFoodId();
                Example foodEx = new Example(Food.class);
                foodEx.createCriteria().andEqualTo("food_id", foodid);
                List<Food> foods = foodMapper.selectByExample(foodEx);
                for(Food food : foods) {
                    foodname = food.getFdName();
                    price = food.getFdPrice();
                    dprice = price.doubleValue();
                }
                for(CustumerConsumption consumption : CustumerConsumptionlist){
                    if(consumption.getFoodName().equals(foodname)){
                        consumption.setFoodNum(consumption.getFoodNum()+item.getAmount());
                        consumption.setTotalPrice(consumption.getTotalPrice()+dprice*item.getAmount());
                        isexist = 1;
                        break;
                    }
                }
                if(isexist==0){
                    CustumerConsumption newconsumption = new CustumerConsumption();
                    newconsumption.setFoodName(foodname);
                    newconsumption.setFoodNum(item.getAmount());
                    newconsumption.setTotalPrice(dprice*item.getAmount());
                    CustumerConsumptionlist.add(newconsumption);
                }
                isexist = 0;
            }
        }
        return CustumerConsumptionlist;
    }

    public List<CustumerConsumption> getCustumerConsumptionThisMonth(){
        return getCustumerConsumptionList(getOrderListThisMonth());
    }
}
