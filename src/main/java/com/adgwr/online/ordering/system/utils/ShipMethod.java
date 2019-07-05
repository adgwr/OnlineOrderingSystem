package com.adgwr.online.ordering.system.utils;

/**
 * @author LiYuHan
 * @title ShipMethod
 * @description 配送方法枚举类
 * @date 3/7/2019 下午4:32
 */
public enum  ShipMethod {

    DELIVERY("商家配送"),
    FETCH("用户自取"),
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
    private ShipMethod(String dec) {
        this.dec = dec;
    }

}
