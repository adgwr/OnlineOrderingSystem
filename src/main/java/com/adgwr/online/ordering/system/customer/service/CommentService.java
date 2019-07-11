package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.domain.Comments;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.vo.FoodComment;

import java.util.List;

/**
 * 评论的Sercive
 *
 * @author lyc
 * @version 1.0
 */
public interface CommentService {

    /**
     * 添加评论
     *
     * @param orderId 订单id
     * @param foodId 菜品id
     * @param comments 评论
     */
    void addComment(int orderId, int foodId, String comments);

    /**
     * 删除评论
     *
     * @param orderId 订单id
     * @param foodId 菜品id
     */
    void deleteComment(int orderId, int foodId);

    /**
     * 返回某个菜品的所有评论
     *
     * @param foodId 菜品id
     * @return 菜品评论列表
     */
    List<FoodComment> getFoodComment(int foodId);

    /**
     * 返回当前订单待评价的菜品列表
     *
     * @param orderId 订单id
     * @return 菜品列表
     */
    List<Food> getFoodList(int orderId);
}
