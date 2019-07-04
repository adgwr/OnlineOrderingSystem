package com.adgwr.online.ordering.system.customer.service.impl;

import com.adgwr.online.ordering.system.customer.service.CommentService;
import com.adgwr.online.ordering.system.domain.Comments;
import com.adgwr.online.ordering.system.mapper.CommentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
@Transactional(readOnly = false)
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentsMapper commentsMapper;

    @Override
    public void addComment(int orderId, int foodId, String commentStr) {
        Comments comments = new Comments();
        comments.setComment(commentStr);
        comments.setFoodId(foodId);
        comments.setOrderId(orderId);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        comments.setCommentDate(df.format(new Date()));

        commentsMapper.insert(comments);
    }

    @Override
    public void deleteComment(int orderId, int foodId) {
        Comments comments = new Comments();
        comments.setFoodId(foodId);
        comments.setOrderId(orderId);

        commentsMapper.deleteByPrimaryKey(comments);
    }

    @Override
    public List<Comments> getFoodComment(int foodId) {
        Example example = new Example(Comments.class);
        example.createCriteria().andEqualTo("foodId", foodId);

        List<Comments> comments = commentsMapper.selectByExample(example);
        return comments;
    }
}
