package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.domain.Comments;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.vo.FoodComment;

import java.util.List;

public interface CommentService {

    /**
     * 添加评论
     *
     * @param orderId
     * @param foodId
     * @param comments
     */
    void addComment(int orderId, int foodId, String comments);

    /**
     * 删除评论
     *
     * @param orderId
     * @param foodId
     */
    void deleteComment(int orderId, int foodId);

    /**
     * 返回某个菜品的所有评论
     *
     * @param foodId
     * @return
     */
    List<FoodComment> getFoodComment(int foodId);

    /**
     * 返回当前订单待评价的菜品列表
     *
     * @param orderId
     * @return
     */
    List<Food> getFoodList(int orderId);
}
