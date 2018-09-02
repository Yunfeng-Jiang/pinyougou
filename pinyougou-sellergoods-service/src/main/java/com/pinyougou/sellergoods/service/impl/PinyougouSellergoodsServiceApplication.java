package com.pinyougou.sellergoods.service.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaServer
@ComponentScan(basePackages = {"com.pinyougou.mapper"})
public class PinyougouSellergoodsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PinyougouSellergoodsServiceApplication.class, args);
        System.out.println("~~~~~Sellergoods-Service-Cloud 启动成功！~~~~~~~~~~~~~~");
    }
}
