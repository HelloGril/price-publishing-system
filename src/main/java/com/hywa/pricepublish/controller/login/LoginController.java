package com.hywa.pricepublish.controller.login;

import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.dao.entity.User;
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
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/verifyUser", method = RequestMethod.POST)
    public ResponseEntity<ResponseBase> login(@RequestParam(required = true) String userName,
                                              @RequestParam(required = true) String psw) {
        User user = userService.findByName(userName);
        ResponseBase<UserRep> userRepResponseBase = new ResponseBase<>();
        if (user != null && user.getPassword().equals(psw)) {

            UserRep userRep = new UserRep(user.getId(), user.getUsername(), user.getRealName(),
                    user.getPhone(), user.getSex(), user.getJobTitle(), user.getAge());

            userRepResponseBase.setRetBody(userRep);
            userRepResponseBase.setRetHead(ConstantPool.SUCCESS, "登陆成功");
        } else {
            userRepResponseBase.setRetHead(ConstantPool.FAILURE, "用户名密码错误，请重新登录");
        }
        return new ResponseEntity<>(userRepResponseBase, HttpStatus.OK);
    }
}
