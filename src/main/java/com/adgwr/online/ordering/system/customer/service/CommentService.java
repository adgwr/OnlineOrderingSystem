package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.domain.Comments;

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
    List<Comments> getFoodComment(int foodId);
}
