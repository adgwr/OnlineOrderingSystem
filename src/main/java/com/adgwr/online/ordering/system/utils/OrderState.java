package com.adgwr.online.ordering.system.utils;

/**
 * @author LiYuHan
 * @title OrderState
 * @description 订单状态枚举类
 * @date 3/7/2019 下午4:25
 */
public enum OrderState {

    PAID("已支付"),
    UNPAID("未支付"),
    PREPARING("已接单"),
    DELIVERING("配送中"),
    CANCELED("已取消"),
    COMPLETE("完成"),
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
