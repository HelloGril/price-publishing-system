package com.hywa.pricepublish.service;

import com.hywa.pricepublish.dao.entity.User;

import java.util.List;
import java.util.Map;


public interface UserService {
    User findByName(String username);

    void save(String userName, String psw);

    Map<String,List<String>> findRolesAndPermissionsByUserName(String username);
}
