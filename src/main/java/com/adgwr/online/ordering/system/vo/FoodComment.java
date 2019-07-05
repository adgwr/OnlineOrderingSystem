package com.adgwr.online.ordering.system.vo;

import com.adgwr.online.ordering.system.domain.Comments;

public class FoodComment {

    private int orderId;
    private int foodId;
    private String cId;
    private String comments;
    private String commentDate;

    public FoodComment(Comments comment) {
        this.foodId = comment.getFoodId();
        this.orderId = comment.getOrderId();
        this.comments = comment.getComment();
        this.commentDate = comment.getCommentDate();
    }

    public FoodComment(int orderId, int foodId, String cId, String comments, String commentDate) {
        this.orderId = orderId;
        this.foodId = foodId;
        this.cId = cId;
        this.comments = comments;
        this.commentDate = commentDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }
}
