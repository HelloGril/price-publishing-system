package com.hywa.pricepublish.service.login.impl;

import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.common.exception.SexInputException;
import com.hywa.pricepublish.common.utils.StringUtils;
import com.hywa.pricepublish.dao.entity.User;
import com.hywa.pricepublish.dao.mapper.RoleMapper;
import com.hywa.pricepublish.dao.mapper.UserAreaMapper;
import com.hywa.pricepublish.dao.mapper.UserMapper;
import com.hywa.pricepublish.representation.UserRep;
import com.hywa.pricepublish.service.login.UserAreaService;
import com.hywa.pricepublish.service.login.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UserAreaMapper userAreaMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private UserAreaService userAreaService;

    @Override
    public void save(UserRep userRep) throws SexInputException {
        User user = new User(userRep);
        userMapper.insert(user);
    }

    @Override
    public List<User> findUsers(String region, String workUnit) {
        //TODO
        return userMapper.selectByRegionAndWorkUnit(region, workUnit);
    }

    @Override
    public User findByName(String userName) {
        return userMapper.selectByUserName(userName);
    }

    @Override
    public UserRep userLogin(String userName, String psw) {
        User user = userMapper.selectByUserName(userName);
        if (user != null && user.getPassword().equals(StringUtils.md5(psw))) {
            if (user.getIsDel() == ConstantPool.DEL) {
                throw new RuntimeException("用户已经注销，请联系管理员！");
            } else {
                String regionId = userAreaService.findRegionId(user.getId());
                UserRep userRep = new UserRep(user.getId(), user.getName(), user.getTelephone(),
                        user.getSex(), user.getJob(), user.getWorkUnit(), user.getAge(), regionId);
                //TODO 生成token
                return userRep;
            }
        } else {
            throw  new RuntimeException("用户名密码错误，请重新登录");
        }
    }
}
