package com.hywa.pricepublish.controller.login;

import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.common.MD5Utils;
import com.hywa.pricepublish.common.exception.SexInputException;
import com.hywa.pricepublish.dao.entity.User;
import com.hywa.pricepublish.representation.ResponseBase;
import com.hywa.pricepublish.representation.UserRep;
import com.hywa.pricepublish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<ResponseBase> login(@RequestParam(required = true) String userName,
                                              @RequestParam(required = true) String psw) {
        User user = userService.findByName(userName);
        ResponseBase<UserRep> userRepResponseBase = new ResponseBase<>();
        if (user != null && user.getPassword().equals(MD5Utils.md5(psw))) {
            UserRep userRep = new UserRep(user.getId(), user.getName(), user.getTelephone(),
                    user.getSex(), user.getJob(), user.getWorkUnit(), user.getAge());
            userRepResponseBase.setRetBody(userRep);
            userRepResponseBase.setRetHead(ConstantPool.SUCCESS, "登陆成功");
        } else {
            userRepResponseBase.setRetHead(ConstantPool.FAILURE, "用户名密码错误，请重新登录");
        }

        return new ResponseEntity<>(userRepResponseBase, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<ResponseBase> registerUser(@Valid @RequestBody UserRep userRep) throws SexInputException {
        userService.save(userRep);
        ResponseBase<UserRep> userRepResponseBase = new ResponseBase<>();
        userRepResponseBase.setRetHead(ConstantPool.SUCCESS, "注册成功");
        return new ResponseEntity<>(userRepResponseBase, HttpStatus.OK);
    }
}
