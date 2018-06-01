package com.hywa.pricepublish.service.impl;

import com.hywa.pricepublish.dao.entity.User;
import com.hywa.pricepublish.dao.entity.UserExample;
import com.hywa.pricepublish.dao.mapper.UserMapper;
import com.hywa.pricepublish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void save(String userName, String psw, int authority) {
        User user = new User();
        user.setUsername(userName);
        user.setPassword(psw);
        user.setAuthority(authority);
        userMapper.insert(user);
    }

    @Override
    public User findByName(String username) {
        return null;
    }

    @Override
    public List<User> selectByMap(Map<String, Object> map) {
        UserExample example = new UserExample();
        example.createCriteria().andEmailIsNotNull();
        return userMapper.selectByExample(example);
    }
}
