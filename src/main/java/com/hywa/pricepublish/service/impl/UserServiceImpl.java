package com.hywa.pricepublish.service.impl;

import com.hywa.pricepublish.common.UUIDUtils;
import com.hywa.pricepublish.dao.entity.Role;
import com.hywa.pricepublish.dao.entity.User;
import com.hywa.pricepublish.dao.entity.UserExample;
import com.hywa.pricepublish.dao.mapper.PermissionMapper;
import com.hywa.pricepublish.dao.mapper.RoleMapper;
import com.hywa.pricepublish.dao.mapper.UserMapper;
import com.hywa.pricepublish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public void save(String userName, String psw) {
        User user = new User();
        user.setId(UUIDUtils.randomUUID());
        user.setUsername(userName);
        user.setPassword(psw);
        userMapper.insert(user);
    }

    @Override
    public Map<String, List<String>> findRolesAndPermissionsByUserName(String username) {
        User user = userMapper.selectByUserName(username);
        Map<String, List<String>> rolesAndPermissions = new HashMap<>();
        List<Role> roles = roleMapper.selectByUserId(user.getId());
        List<String> strRoles = new ArrayList<>();
        List<String> strPermissions = new ArrayList<>();

        roles.forEach(role -> {
            strRoles.add(role.getName());
            strPermissions.addAll(permissionMapper.selectByRoleId(role.getId()));
        });

        rolesAndPermissions.put("roles", strRoles);
        rolesAndPermissions.put("permissions", strPermissions);
        return rolesAndPermissions;
    }

    @Override
    public User findByName(String userName) {
        return userMapper.selectByUserName(userName);
    }
}
