package com.adgwr.online.ordering.system.customer.service.impl;

import com.adgwr.online.ordering.system.customer.service.CommentService;
import com.adgwr.online.ordering.system.domain.Comments;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.domain.Lineitem;
import com.adgwr.online.ordering.system.domain.MyOrder;
import com.adgwr.online.ordering.system.mapper.CommentsMapper;
import com.adgwr.online.ordering.system.mapper.FoodMapper;
import com.adgwr.online.ordering.system.mapper.LineitemMapper;
import com.adgwr.online.ordering.system.mapper.MyOrderMapper;
import com.adgwr.online.ordering.system.vo.FoodComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Transactional(readOnly = false)
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentsMapper commentsMapper;

    @Autowired
    private MyOrderMapper myOrderMapper;

    @Autowired
    private LineitemMapper lineitemMapper;

    @Autowired
    private FoodMapper foodMapper;

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
    public List<FoodComment> getFoodComment(int foodId) {
        Example example = new Example(Comments.class);
        example.createCriteria().andEqualTo("foodId", foodId);

        List<Comments> commentsList = commentsMapper.selectByExample(example);
        List<FoodComment> comments = new ArrayList<>();
        for(Comments c : commentsList) {
            FoodComment fc = new FoodComment(c);
            MyOrder myOrder = myOrderMapper.selectByPrimaryKey(fc.getOrderId());
            fc.setcId(myOrder.getcId());
        }
        return comments;
    }

    @Override
    public List<Food> getFoodList(int orderId) {
        Example example = new Example(Lineitem.class);
        example.createCriteria().andEqualTo("orderId", orderId);
        List<Lineitem> lineitems = lineitemMapper.selectByExample(example);
        List<Food> foods = new ArrayList<>();
        for(Lineitem l : lineitems) {
            Food food = foodMapper.selectByPrimaryKey(l.getFoodId());
            foods.add(food);
        }
        return foods;
    }


}
