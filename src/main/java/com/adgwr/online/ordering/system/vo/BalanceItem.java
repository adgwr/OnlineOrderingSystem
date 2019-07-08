package com.adgwr.online.ordering.system.vo;

import com.adgwr.online.ordering.system.domain.Food;

import java.math.BigDecimal;

public class BalanceItem {

    private Integer foodId;
    private String foodName;
    private String fdImage;
    private BigDecimal foodPrice;
    private Integer amount;
    private BigDecimal totalPrice;

    public BalanceItem(Food food) {
        this.foodId = food.getFoodId();
        this.foodName = food.getFdName();
        this.fdImage = food.getFdImage();
        this.foodPrice = food.getFdPrice();
    }

    public Integer getFoodId() {
        return foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFdImage() {
        return fdImage;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
        this.totalPrice = foodPrice.multiply(new BigDecimal(amount));
        this.totalPrice.setScale(2);
    }

    public BigDecimal getFoodPrice() {
        return foodPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
