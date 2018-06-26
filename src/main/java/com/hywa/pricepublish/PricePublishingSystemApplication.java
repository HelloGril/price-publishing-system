package com.hywa.pricepublish;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableAutoConfiguration
//配置druid必须加的注解，如果不加，访问页面打不开，filter和servlet、listener之类的需要单独进行注册才能使用，
// spring boot里面提供了该注解起到注册作用
@ServletComponentScan
@MapperScan(basePackages = "com.hywa.pricepublish.dao.mapper")
public class PricePublishingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PricePublishingSystemApplication.class, args);
    }
}
