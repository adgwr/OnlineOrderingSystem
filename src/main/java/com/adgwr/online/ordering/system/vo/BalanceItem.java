package com.adgwr.online.ordering.system.vo;

import com.adgwr.online.ordering.system.domain.Food;

import java.math.BigDecimal;

/**
 * 本类保存了结算信息
 *
 * @author lyc
 * @version  1.0
 */
public class BalanceItem {

    /**
     * 菜品id
     */
    private Integer foodId;

    /**
     * 菜品名称
     */
    private String foodName;

    /**
     * 菜品图片位置
     */
    private String fdImage;

    /**
     * 菜品价格
     */
    private BigDecimal foodPrice;

    /**
     * 菜品数量
     */
    private Integer amount;

    /**
     * 该菜品的总价格
     */
    private BigDecimal totalPrice;

    /**
     * 初始化实例
     *
     * @param food 使用Food类初始化
     */
    public BalanceItem(Food food) {
        this.foodId = food.getFoodId();
        this.foodName = food.getFdName();
        this.fdImage = food.getFdImage();
        this.foodPrice = food.getFdPrice();
    }

    /**
     * 返回foodId
     *
     * @return foodId
     */
    public Integer getFoodId() {
        return foodId;
    }

    /**
     * 返回菜品名称
     *
     * @return foodName
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * 返回菜品图片路径
     *
     * @return fdImage
     */
    public String getFdImage() {
        return fdImage;
    }

    /**
     * 返回菜品数量
     *
     * @return amount
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * 设置菜品数量
     *
     * @param amount 菜品数量
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
        this.totalPrice = foodPrice.multiply(new BigDecimal(amount));
        this.totalPrice.setScale(2);
    }

    /**
     * 返回菜品价格
     *
     * @return foodPrice
     */
    public BigDecimal getFoodPrice() {
        return foodPrice;
    }

    /**
     * 返回菜品总价格
     *
     * @return totalPrice
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
