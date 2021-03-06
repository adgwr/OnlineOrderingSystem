package com.adgwr.online.ordering.system.admin.controller;

import com.adgwr.online.ordering.system.admin.service.FoodService;
import com.adgwr.online.ordering.system.admin.service.AdminOrderService;
import com.adgwr.online.ordering.system.admin.service.SalesService;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.domain.Lineitem;
import com.adgwr.online.ordering.system.domain.MyOrder;
import com.adgwr.online.ordering.system.vo.Sale;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author rch/dev
 */
@Controller
public class SalesController {

    @Autowired
    private SalesService salesService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private AdminOrderService adminOrderService;

    /**
     * 转向salesView.html界面，并传递saleList
     * @param model
     * @return
     */
    @RequestMapping(value = "admin/salesView", method = RequestMethod.GET)
    public String salesView(Model model,
                            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                            @RequestParam(value = "viewMethod", defaultValue = "today") String viewMethod) throws ParseException {
        PageHelper.startPage(pn, 5);
        PageHelper.orderBy("order_id asc");

        List<Sale> saleList;
        if(viewMethod.equals("today")) {
            saleList = salesSelected(getOrderListDaily());
        }else if(viewMethod.equals("thisWeek")) {
            saleList = salesSelected(getOrderListWeek());
        }else {
            saleList = salesSelected(getOrderListMonth());
        }

        PageInfo page = new PageInfo(saleList, 3);
        if(page.getPages() == 0) {
            model.addAttribute("hasFood", false);
        }
        else {
            model.addAttribute("hasFood", true);
            model.addAttribute("currentPage",page.getPageNum());
            int start = (pn-1)/5*5+1;
            int end = Math.min(start+4,page.getPages());
            model.addAttribute("hasStart",start != 1);
            model.addAttribute("hasEnd",end != page.getPages());
            model.addAttribute("startPage", start);
            model.addAttribute("endPage", end);
        }
        model.addAttribute("viewMethod",viewMethod);
        model.addAttribute("saleList",saleList);
        return "admin/salesView";
    }

    /**
     * 根据当天/周/月的已付款订单计算销售情况
     * @param myOrderList
     * @return
     */
    public List<Sale> salesSelected(List<MyOrder> myOrderList) {
        List<Food> foodList = foodService.getAllFood();
        List<Sale> saleList = new ArrayList<Sale>();
        //1.获取当天/周/月已付款的订单
        //myOrderList
        //2.根据当天/周/月已付款订单的ID找到所有的Lineitem
        List<Lineitem> allLineitemList = new ArrayList<Lineitem>();
        for(MyOrder myOrder:myOrderList) {
            List<Lineitem> lineitemList = salesService.getLineItemByOrderId(myOrder.getOrderId());
            allLineitemList.addAll(lineitemList);
        }
        //3.根据找到的allLineitemList计算sale
        //获取saleList
        for(Food food:foodList) {
            Sale sale = new Sale();
            sale.setFoodId(food.getFoodId());
            sale.setFoodName(food.getFdName());
            List<Lineitem> lineitemList = getLineItemByFoodId(allLineitemList,food.getFoodId());
            int amount = 0;
            for(Lineitem lineitem:lineitemList) {
                amount += lineitem.getAmount();
            }
            sale.setAmount(amount);
            saleList.add(sale);
        }
        return saleList;
    }

    /**
     * 找出当天的已付款订单
     * @return
     */
    private List<MyOrder> getOrderListDaily() throws ParseException {
        //所有的已完成订单
        List<MyOrder> allMyOrderList = adminOrderService.showFinishedOrderList();
        String sqldate = null;
        Date dateforchange = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //当前日期
        String currentdate = df.format(new Date());
        List<MyOrder> myOrderList = new ArrayList<MyOrder>();
        for(MyOrder myOrder:allMyOrderList) {
            sqldate = myOrder.getOrderDate();
            dateforchange = df.parse(sqldate);
            sqldate = df.format(dateforchange);
            if(sqldate.equals(currentdate)) {
                myOrderList.add(adminOrderService.getOrderById(myOrder.getOrderId()));
            }
        }
        return myOrderList;
    }

    /**
     * 找出当周的已付款订单
     * @return
     */
    private List<MyOrder> getOrderListWeek() throws ParseException {
        //所有的已完成订单
        List<MyOrder> allMyOrderList = adminOrderService.showFinishedOrderList();

        // 设置时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //当前日期
        Date endDate = new Date();
        String currentdate = sdf.format(endDate);
        Calendar cal = Calendar.getInstance();
        Date time = sdf.parse(currentdate);
        cal.setTime(time);

        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值，则得到当前周的周一
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        String mondayDate = sdf.format(cal.getTime()) + " 00:00:00";
        Date startDate = sdf2.parse(mondayDate);

        List<MyOrder> myOrderList = new ArrayList<MyOrder>();
        Date sqldate = null;
        for(MyOrder myOrder:allMyOrderList) {
            sqldate = sdf2.parse(myOrder.getOrderDate());
            if(sqldate.compareTo(startDate)>=0 && sqldate.compareTo(endDate)<=0) {
                myOrderList.add(adminOrderService.getOrderById(myOrder.getOrderId()));
            }
        }
        return myOrderList;
    }

    /**
     * 找出当月的已付款订单
     * List
     * @return
     */
    private List<MyOrder> getOrderListMonth() throws ParseException {
        //所有的已完成订单
        List<MyOrder> allMyOrderList = adminOrderService.showFinishedOrderList();

        // 设置时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //当前日期
        Date endDate = new Date();
        Calendar cal = Calendar.getInstance();// 获取当前日期
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        String firstDay = sdf.format(cal.getTime()) + " 00:00:00";
        Date startDate = sdf2.parse(firstDay);

        List<MyOrder> myOrderList = new ArrayList<MyOrder>();
        Date sqldate = null;
        for(MyOrder myOrder:allMyOrderList) {
            sqldate = sdf2.parse(myOrder.getOrderDate());
            if(sqldate.compareTo(startDate)>=0 && sqldate.compareTo(endDate)<=0) {
                myOrderList.add(adminOrderService.getOrderById(myOrder.getOrderId()));
            }
        }
        return myOrderList;
    }

    /**
     * 根据foodid和当天/周/月已完成的订单项中找出与该食品相关的记录
     * @param allLineitemList
     * @param foodId
     * @return
     */
    private List<Lineitem> getLineItemByFoodId(List<Lineitem> allLineitemList, int foodId) {
        List<Lineitem> lineitemList = new ArrayList<Lineitem>();
        for(Lineitem lineitem:allLineitemList) {
            if(lineitem.getFoodId().equals(foodId))
                lineitemList.add(lineitem);
        }
        return lineitemList;
    }

}
