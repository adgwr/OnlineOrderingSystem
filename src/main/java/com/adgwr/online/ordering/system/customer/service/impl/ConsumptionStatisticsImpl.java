package com.adgwr.online.ordering.system.customer.service.impl;

import com.adgwr.online.ordering.system.customer.service.ConsumptionStatisticsService;
import com.adgwr.online.ordering.system.domain.MyOrder;
import com.adgwr.online.ordering.system.domain.Lineitem;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.mapper.LineitemMapper;
import com.adgwr.online.ordering.system.mapper.MyOrderMapper;
import com.adgwr.online.ordering.system.mapper.FoodMapper;
import com.adgwr.online.ordering.system.vo.CustumerConsumption;
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
import java.util.Collections;

@Service
@Transactional(readOnly = false)
public class ConsumptionStatisticsImpl implements ConsumptionStatisticsService{

    @Autowired
    private MyOrderMapper orderMapper;

    @Autowired
    private LineitemMapper lineitemMapper;

    @Autowired
    private FoodMapper foodMapper;

    public boolean isInDate(String dt, String dt1, String dt2)  {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        Date date1 = null;
        Date date2 = null;
        try {
            date = df.parse(dt);
            date1 = df.parse(dt1);
            date2 = df.parse(dt2);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return date.compareTo(date1) >= 0 && date.compareTo(date2) <= 0;
    }

    public List<CustumerConsumption> getCustumerConsumptionList(List<Integer> orderIdList){
        int foodid;
        String foodname=null;
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
                foodEx.createCriteria().andEqualTo("foodId", foodid);
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
        Collections.sort(CustumerConsumptionlist);
        return CustumerConsumptionlist;
    }

    public List<Integer> getOrderListDaily(String date)  {
        Example OrderEx = new Example(MyOrder.class);
        OrderEx.createCriteria().andEqualTo("orderState", "已完成");
        List<MyOrder> orders = orderMapper.selectByExample(OrderEx);

        int orderid;
        String sqldate;
        Date dateforchange;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        List<Integer> orderIdList = new ArrayList<>();

        for(MyOrder order : orders) {
            sqldate = order.getOrderDate();
            try {
                dateforchange = df.parse(sqldate);

                sqldate = df.format(dateforchange);
                if (sqldate.equals(date)) {
                    orderid = order.getOrderId();
                    orderIdList.add(orderid);
                }
            }catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return orderIdList;
    }

    public List<Integer> getOrderListDaily(String date,String custumerId)  {
        Example OrderEx = new Example(MyOrder.class);
        Example.Criteria criteria = OrderEx.createCriteria();
        criteria.andEqualTo("orderState", "已完成");
        criteria.andEqualTo("c_id", custumerId);
        List<MyOrder> orders = orderMapper.selectByExample(OrderEx);

        int orderid;
        String sqldate;
        Date dateforchange;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        List<Integer> orderIdList = new ArrayList<>();

        for(MyOrder order : orders) {
            sqldate = order.getOrderDate();
            try {
                dateforchange = df.parse(sqldate);
                sqldate = df.format(dateforchange);
                if (sqldate.equals(date)) {
                    orderid = order.getOrderId();
                    orderIdList.add(orderid);
                }
            } catch (ParseException e) {
                System.out.println("");
                e.printStackTrace();
            }
        }
        return orderIdList;
    }

    public List<Integer> getOrderListThisWeek() {
        Example OrderEx = new Example(MyOrder.class);
        OrderEx.createCriteria().andEqualTo("orderState", "已完成");
        List<MyOrder> orders = orderMapper.selectByExample(OrderEx);

        int orderid;
        List<Integer> orderIdList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        String nowDate = sdf2.format(new Date());// endDate
        Calendar cal = Calendar.getInstance();
        Date time = null;
        try {
            time = sdf.parse(date);
            cal.setTime(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        String mondayDate = sdf.format(cal.getTime());
        mondayDate = mondayDate + " 00:00:00";// startDate
        String sqldate;

        for(MyOrder order : orders) {
            sqldate = order.getOrderDate();
            if (isInDate(sqldate, mondayDate, nowDate)) {
                orderid = order.getOrderId();
                orderIdList.add(orderid);
            }
        }
        return orderIdList;

    }

    public List<Integer> getOrderListThisWeek(String custumerId) {
        Example OrderEx = new Example(MyOrder.class);
        Example.Criteria criteria = OrderEx.createCriteria();
        criteria.andEqualTo("orderState", "已完成");
        criteria.andEqualTo("c_id", custumerId);
        List<MyOrder> orders = orderMapper.selectByExample(OrderEx);

        int orderid;
        List<Integer> orderIdList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        String nowDate = sdf2.format(new Date());// endDate
        Calendar cal = Calendar.getInstance();
        Date time = null;
        try {
            time = sdf.parse(date);
            cal.setTime(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        String mondayDate = sdf.format(cal.getTime());
        mondayDate = mondayDate + " 00:00:00";// startDate
        String sqldate;

        for(MyOrder order : orders) {
            sqldate = order.getOrderDate();
            if (isInDate(sqldate, mondayDate, nowDate)) {
                orderid = order.getOrderId();
                orderIdList.add(orderid);
            }
        }
        return orderIdList;

    }

    public List<Integer> getOrderListThisMonth(){
        Example OrderEx = new Example(MyOrder.class);
        OrderEx.createCriteria().andEqualTo("orderState", "已完成");
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
                orderid = order.getOrderId();
                orderIdList.add(orderid);
            }
        }
        return orderIdList;
    }

    public List<Integer> getOrderListThisMonth(String custumerId){
        Example OrderEx = new Example(MyOrder.class);
        Example.Criteria criteria = OrderEx.createCriteria();
        criteria.andEqualTo("orderState", "已完成");
        criteria.andEqualTo("c_id", custumerId);
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
                orderid = order.getOrderId();
                orderIdList.add(orderid);
            }
        }
        return orderIdList;
    }

    public List<CustumerConsumption> getCustumerConsumptionToday(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());
        return getCustumerConsumptionList(getOrderListDaily(date));
    }

    public List<CustumerConsumption> getCustumerConsumptionToday(String custumerId){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());
        return getCustumerConsumptionList(getOrderListDaily(date,custumerId));
    }

    public List<CustumerConsumption> getCustumerConsumptionThisWeek(){
        return getCustumerConsumptionList(getOrderListThisWeek());
    }

    public List<CustumerConsumption> getCustumerConsumptionThisWeek(String custumerId){
        return getCustumerConsumptionList(getOrderListThisWeek(custumerId));
    }

    public List<CustumerConsumption> getCustumerConsumptionThisMonth(){
        return getCustumerConsumptionList(getOrderListThisMonth());
    }

    public List<CustumerConsumption> getCustumerConsumptionThisMonth(String custumerId){
        return getCustumerConsumptionList(getOrderListThisMonth(custumerId));
    }

}
