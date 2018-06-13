package com.hywa.pricepublish.controller.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {
//    @RequestMapping(value = "/getExcel")
//    public void getExcel(HttpServletResponse response) throws UnsupportedEncodingException {
//        response.setContentType("application/vnd.ms-excel;charset=utf-8");
//        //中文文件名做iso-8859-1转码
//        response.setHeader("Content-Disposition", "attachment;filename=" + new String("用户列表".getBytes("gbk"), "iso8859-1") + ".xls");
//        try {
//            ServletOutputStream outputStream = response.getOutputStream();
//            userService.createUserExcel(outputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
