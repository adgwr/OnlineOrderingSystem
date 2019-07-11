package com.adgwr.online.ordering.system.utils;

/**
 * @author LiYuHan
 * @title OrderState
 * @description 订单状态枚举类
 * @date 3/7/2019 下午4:25
 */
public enum OrderState {

    UNPAID("未付款"),
    PAID("已付款"),
    DELIVERING("正在配送"),
    PREPARING("已接单"),
    COMMENT("待评价"),
    COMPLETE("已完成"),
    CANCELED("已取消"),
    ;

    /**中文描述*/
    private String dec;

    /**
     * 得到中文描述
     * @return 中文描述
     */
    public String getDec() {
        return dec;
    }

    /**
     * 私有构造，防止外部调用
     * @param dec
     */
    private OrderState(String dec) {
        this.dec = dec;
    }
}
