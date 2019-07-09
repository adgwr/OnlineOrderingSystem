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
     * 统计某个用户在一段时间范围里面的消费情况
     * @param cId 用户id
     * @param scope 范围
     * @return 消费情况对象的list
     */
    List<CustumerConsumption> getConsumptionWithScope(String cId, String scope);
}
