package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.utils.ShipMethod;
import com.adgwr.online.ordering.system.vo.CustumerConsumption;
import java.text.ParseException;
import java.util.List;

/**
 * @author LiYuHan
 * @title ConsumptionStatistics
 * @description 用户的消费统计service
 * @date 4/7/2019 下午3:59
 */
public interface ConsumptionStatisticsService {

    /**
     * 统计当天的销售情况
     *
     * @return 返回一个CustumerConsumption对象的list，每个CustumerConsumption存放了对应菜品的名称，当天销量及销售额
     */
    List<CustumerConsumption> getCustumerConsumptionToday();

    /**
     * 统计某个用户当天的购买情况
     * @param custumerId 需要查询的顾客的c_id
     * @return 返回一个CustumerConsumption对象的list，每个CustumerConsumption存放了对应菜品的名称，当天购买量及总花费
     */
    List<CustumerConsumption> getCustumerConsumptionToday(String custumerId);

    /**
     * 统计当周的（从周一0点到当前）销售情况
     *
     * @return 返回一个CustumerConsumption对象的list，每个CustumerConsumption存放了对应菜品的名称，当周销量及销售额
     */
    List<CustumerConsumption> getCustumerConsumptionThisWeek();

    /**
     * 统计某个用户当周的购买情况
     * @param custumerId 需要查询的顾客的c_id
     * @return 返回一个CustumerConsumption对象的list，每个CustumerConsumption存放了对应菜品的名称，当周购买量及总花费
     */
    List<CustumerConsumption> getCustumerConsumptionThisWeek(String custumerId);

    /**
     * 统计当月的（从1号0点到当前）销售情况
     *
     * @return 返回一个CustumerConsumption对象的list，每个CustumerConsumption存放了对应菜品的名称，当月销量及销售额
     */
    List<CustumerConsumption> getCustumerConsumptionThisMonth();

    /**
     * 统计某个用户当月的购买情况
     * @param custumerId 需要查询的顾客的c_id
     * @return 返回一个CustumerConsumption对象的list，每个CustumerConsumption存放了对应菜品的名称，当月购买量及总花费
     */
    List<CustumerConsumption> getCustumerConsumptionThisMonth(String custumerId);

}
