package com.adgwr.online.ordering.system.vo;

import java.util.List;
import java.math.BigDecimal;
/**
 * @author LiYuHan
 * @title CustumerConsumption
 * @description
 * @date 4/7/2019 下午3:54
 */
public class CustumerConsumption implements Comparable<CustumerConsumption>{
    

    private String foodName;
    private int foodNum;
    private double totalPrice;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodNum() {
        return foodNum;
    }

    public void setFoodNum(int foodNum) {
        this.foodNum = foodNum;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 先比较价格在比较数量
     * @param o
     * @return
     */
    @Override
    public int compareTo(CustumerConsumption o) {
        if(o.getTotalPrice()>this.getTotalPrice())return 1;
        else if(o.getTotalPrice()<this.getTotalPrice())return -1;
        else return o.getFoodNum() - this.getFoodNum();
    }

}
