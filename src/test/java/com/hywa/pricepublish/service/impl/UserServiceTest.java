package com.hywa.pricepublish.service.impl;

import com.hywa.pricepublish.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void save() {

    }

    @Test
    public void findByName() {
//        User junFang = userService.findByName("junfang");
//        Assert.assertNotNull(junFang);
//
//        User acceptData = userService.findByName("dsafdsaf");
//        Assert.assertNull(acceptData);
    }
}