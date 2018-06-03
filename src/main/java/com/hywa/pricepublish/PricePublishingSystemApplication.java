package com.hywa.pricepublish;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.hywa")
public class PricePublishingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PricePublishingSystemApplication.class, args);
    }
}
