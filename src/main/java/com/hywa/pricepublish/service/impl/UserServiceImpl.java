package com.hywa.pricepublish.service.impl;

import com.hywa.pricepublish.common.ExportExcelUtils;
import com.hywa.pricepublish.common.exception.SexInputException;
import com.hywa.pricepublish.dao.entity.User;
import com.hywa.pricepublish.dao.entity.UserArea;
import com.hywa.pricepublish.dao.mapper.RoleMapper;
import com.hywa.pricepublish.dao.mapper.UserAreaMapper;
import com.hywa.pricepublish.dao.mapper.UserMapper;
import com.hywa.pricepublish.representation.UserRep;
import com.hywa.pricepublish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UserAreaMapper userAreaMapper;

    @Override
    public void save(UserRep userRep) throws SexInputException {
        User user = new User(userRep);
        userMapper.insert(user);
    }

    @Override
    public List<User> findUsers(String region, String workUnit) {
        //TODO mapper.xml 中也为实现
        return null;
    }

    @Override
    public void createUserExcel(ServletOutputStream outputStream) {
        User junfang = userMapper.selectByUserName("junfang");
        ExportExcelUtils.createExcel(junfang, outputStream);
    }

    @Override
    public User findByName(String userName) {
        User user = userMapper.selectByUserName(userName);
        if (user != null) {
            UserArea userArea = userAreaMapper.findUserArea(user.getId());
            UserRep userRep = new UserRep(user.getId(), user.getName(), user.getTelephone(),
                    user.getSex(), user.getJob(), user.getWorkUnit(), user.getAge());
        }
        //TODO
        return user;
    }
}
