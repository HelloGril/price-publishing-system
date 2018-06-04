package com.hywa.pricepublish.service;

import com.hywa.pricepublish.dao.entity.User;

import java.util.List;
import java.util.Map;


public interface UserService {
    List<User> selectByMap(Map<String, Object> map);

    User findByName(String username);

    void save(String userName, String psw, int authority);
}
