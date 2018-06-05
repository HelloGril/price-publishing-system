package com.hywa.pricepublish.controller.login;

import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.representation.ResponseBase;
import com.hywa.pricepublish.representation.UserRep;
import com.hywa.pricepublish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<ResponseBase> login(@RequestParam(required = true) String userName,
                                              @RequestParam(required = true) String psw) {
        userService.save(userName, psw);

        ResponseBase<UserRep> userRepResponseBase = new ResponseBase<>();
        userRepResponseBase.setRetHead(ConstantPool.SUCCESS, "注册成功");
        return new ResponseEntity<>(userRepResponseBase, HttpStatus.OK);
    }
}
