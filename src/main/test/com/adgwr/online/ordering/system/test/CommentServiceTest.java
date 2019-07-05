package com.adgwr.online.ordering.system.test;

import com.adgwr.online.ordering.system.OnlineOrderingSystemApplication;
import com.adgwr.online.ordering.system.customer.service.CommentService;
import com.adgwr.online.ordering.system.domain.Comments;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineOrderingSystemApplication.class)
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Test
    public void testAddComment() {
        commentService.addComment(2,1,"不错");
        commentService.addComment(3,1,"好好好");
    }

    @Test
    public void testDeleteComment() {
        commentService.deleteComment(2,1);
    }

    @Test
    public void testGetFoodComment() {

    }
}
