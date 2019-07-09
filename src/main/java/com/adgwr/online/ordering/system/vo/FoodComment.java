package com.adgwr.online.ordering.system.vo;

import com.adgwr.online.ordering.system.domain.Comments;

/**
 * 本类保存了菜品评论的信息
 *
 * @author 1.0
 * @version 1.0
 */
public class FoodComment {

    /**
     * 订单id
     */
    private int orderId;

    /**
     * 菜品id
     */
    private int foodId;

    /**
     * 客户id
     */
    private String cId;

    /**
     * 评论
     */
    private String comments;

    /**
     * 评论日期
     */
    private String commentDate;

    /**
     * 实例化对象
     *
     * @param comment Comment评论对象
     */
    public FoodComment(Comments comment) {
        this.foodId = comment.getFoodId();
        this.orderId = comment.getOrderId();
        this.comments = comment.getComment();
        this.commentDate = comment.getCommentDate();
    }

    /**
     * 实例化对象
     *
     * @param orderId 订单id
     * @param foodId 菜品id
     * @param cId 客户id
     * @param comments 评论
     * @param commentDate 评论日期
     */
    public FoodComment(int orderId, int foodId, String cId, String comments, String commentDate) {
        this.orderId = orderId;
        this.foodId = foodId;
        this.cId = cId;
        this.comments = comments;
        this.commentDate = commentDate;
    }

    /**
     * 返回订单id
     *
     * @return orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * 返回菜品id
     *
     * @return foodId
     */
    public int getFoodId() {
        return foodId;
    }

    /**
     * 设置菜品id
     *
     * @param foodId 菜品id
     */
    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    /**
     * 返回客户id
     *
     * @return cId
     */
    public String getcId() {
        return cId;
    }

    /**
     * 设置客户id
     *
     * @param cId 客户id
     */
    public void setcId(String cId) {
        this.cId = cId;
    }

    /**
     * 返回评论
     *
     * @return comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * 设置评论
     *
     * @param comments 评论信息
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * 返回评论日期
     *
     * @return commentDate
     */
    public String getCommentDate() {
        return commentDate;
    }

    /**
     * 设置评论日期
     *
     * @param commentDate 评论日期
     */
    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }
}
