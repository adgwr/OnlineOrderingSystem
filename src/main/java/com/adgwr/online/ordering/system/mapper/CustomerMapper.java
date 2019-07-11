package com.adgwr.online.ordering.system.mapper;

import com.adgwr.online.ordering.system.domain.Customer;
import com.adgwr.online.ordering.system.utils.RedisCache;
import com.adgwr.online.ordering.system.vo.CustumerConsumption;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.MyMapper;

import java.util.List;

@CacheNamespace(implementation = RedisCache.class)
public interface CustomerMapper extends MyMapper<Customer> {

    @Select("SELECT fd_name as foodName, sum(amount) as foodNum, sum(total_price) as totalPrice \n" +
            "FROM lineitem, (SELECT order_id FROM my_order WHERE c_id = #{cId}) as my_order, food\n" +
            "WHERE lineitem.order_id = my_order.order_id AND lineitem.food_id = food.food_id\n" +
            "GROUP BY fd_name " +
            "ORDER BY total_price DESC, amount DESC")
    List<CustumerConsumption> getConsumptions(String cId);

    @Select("SELECT fd_name as foodName, sum(amount) as foodNum, sum(total_price) as totalPrice \n" +
            "FROM lineitem, \n" +
            "(SELECT order_id FROM my_order WHERE c_id = #{cId} AND my_order.order_date > #{startDate} \n" +
            "AND my_order.order_date < #{endDate}) as my_order,\n" +
            "food\n" +
            "WHERE lineitem.order_id = my_order.order_id AND lineitem.food_id = food.food_id\n" +
            "GROUP BY fd_name " +
            "ORDER BY total_price DESC, amount DESC")
    List<CustumerConsumption> getConsumptionsWithScope(String cId, String startDate, String endDate);
}