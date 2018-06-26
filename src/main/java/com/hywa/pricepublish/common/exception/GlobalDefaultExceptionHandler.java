package com.hywa.pricepublish.common.exception;

import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.representation.ResponseBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@CrossOrigin
@RestControllerAdvice
@Slf4j
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseBase> defaultErrorHandler(HttpServletRequest req, HttpServletResponse response, Exception e) {
        log.error(req.getRequestURL() + "<:=====:>" +
                req.getMethod() + "<:=====:>" +
                req.getUserPrincipal() + "<:=====:>" +
                req.getQueryString() + "<:=====:>" +
                e.getMessage());
        Enumeration<String> headerNames = req.getHeaderNames();

        ResponseBase userRepResponseBase = new ResponseBase<>();
        if (e instanceof DuplicateKeyException) {
            userRepResponseBase.setRetHead(ConstantPool.FAILURE, "名字不能重复");
        } else {
            userRepResponseBase.setRetHead(ConstantPool.FAILURE, e.getMessage());
        }
        return new ResponseEntity<>(userRepResponseBase, HttpStatus.OK);
    }
}
