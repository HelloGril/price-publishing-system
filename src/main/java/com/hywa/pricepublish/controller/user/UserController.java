package com.hywa.pricepublish.controller.user;

import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.common.exception.SexInputException;
import com.hywa.pricepublish.config.ManyEnvProperties;
import com.hywa.pricepublish.representation.ResponseBase;
import com.hywa.pricepublish.representation.UserRep;
import com.hywa.pricepublish.service.login.UserAreaService;
import com.hywa.pricepublish.service.login.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    ManyEnvProperties manyEnvProperties;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public ResponseEntity<ResponseBase> login(@RequestParam(required = true) String userName,
                                              @RequestParam(required = true) String psw) {
        ResponseBase<UserRep> userRepResponseBase = new ResponseBase<>();
        userService.userLogin(userName, psw);
        userRepResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, "登录成功");

        return new ResponseEntity<>(userRepResponseBase, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<ResponseBase> registerUser(@Valid @RequestBody UserRep userRep) throws SexInputException {
        userService.save(userRep);
        ResponseBase<UserRep> userRepResponseBase = new ResponseBase<>();
        userRepResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        return new ResponseEntity<>(userRepResponseBase, HttpStatus.OK);
    }
}
