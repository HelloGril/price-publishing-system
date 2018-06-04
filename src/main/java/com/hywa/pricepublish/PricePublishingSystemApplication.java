package com.hywa.pricepublish;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan(basePackages = "com.hywa.pricepublish.dao.mapper")
public class PricePublishingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PricePublishingSystemApplication.class, args);
    }
}
