package com.adgwr.online.ordering.system.test;

import com.adgwr.online.ordering.system.OnlineOrderingSystemApplication;
import com.adgwr.online.ordering.system.admin.controller.FoodController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.net.URL;

/**
 * @author LiYuHan
 * @title AdminFoodTest
 * @description
 * @date 10/7/2019 上午11:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineOrderingSystemApplication.class)
@Rollback
@Transactional
public class AdminFoodTest {

    @Autowired
    protected WebApplicationContext wac;

    private MockMvc mockMvc;

    @InjectMocks
    private FoodController controller;

    @Before // 在测试开始前初始化工作
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void t() {
        String url = "admin/food/foodAdd";


//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(url).param("foodSubName", "aabc")
//        .param("foodName", "abc")).param("foodPrice", 12.5).param("foodDesc", "asd");
    }
}
