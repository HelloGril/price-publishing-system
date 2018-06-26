package com.hywa.pricepublish.service.login;

import com.hywa.pricepublish.common.exception.SexInputException;
import com.hywa.pricepublish.dao.entity.User;
import com.hywa.pricepublish.representation.UserRep;

import javax.servlet.ServletOutputStream;
import java.util.List;


public interface UserService {
    User findByName(String username);

    void save(UserRep userRep) throws SexInputException;

    List<User> findUsers(String region, String workUnit);

    UserRep userLogin(String userName, String psw);
}
