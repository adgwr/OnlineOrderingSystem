package com.adgwr.online.ordering.system.domain;

import javax.persistence.*;

public class Shoppingcart {
    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String cId;

    @Id
    @Column(name = "food_id")
    private Integer foodId;

    private Integer amount;

    /**
     * @return c_id
     */
    public String getcId() {
        return cId;
    }

    /**
     * @param cId
     */
    public void setcId(String cId) {
        this.cId = cId;
    }

    /**
     * @return food_id
     */
    public Integer getFoodId() {
        return foodId;
    }

    /**
     * @param foodId
     */
    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    /**
     * @return amount
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * @param amount
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}