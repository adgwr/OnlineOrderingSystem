package com.adgwr.online.ordering.system.test;

import com.adgwr.online.ordering.system.OnlineOrderingSystemApplication;
import com.adgwr.online.ordering.system.customer.service.CollectionService;
import com.adgwr.online.ordering.system.domain.Collections;
import com.adgwr.online.ordering.system.domain.Comments;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineOrderingSystemApplication.class)
public class CollectionServiceTest {

    @Autowired
    private CollectionService collectionService;

    @Test
    public void testAddFood() {
        collectionService.addFood(1,"abc");
        collectionService.addFood(2,"abc");
        collectionService.addFood(3,"abc");
    }

    @Test
    public void testDeleteFood() {
        collectionService.deleteFood(2,"abc");
    }

    @Test
    public void testGetMyCollection() {
        collectionService.getMyCollection("abc");
        List<Collections> collections = collectionService.getMyCollection("abc");
        for(Collections c : collections) {
            System.out.println(c.getcId() + ":" + c.getFoodId());
        }
    }
}
