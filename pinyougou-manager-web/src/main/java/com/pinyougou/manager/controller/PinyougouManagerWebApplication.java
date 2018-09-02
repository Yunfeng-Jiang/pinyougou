package com.pinyougou.manager.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@ComponentScan(basePackages = {"com.pinyougou"})
@MapperScan(basePackages = "com.pinyougou.mapper")
public class PinyougouManagerWebApplication {


    public static void main(String[] args) {
        SpringApplication.run(PinyougouManagerWebApplication.class, args);
        System.out.println("~~~~~~~~~~Spring-Cloud-Consumer启动完毕！~~~~~~~~~~~");
    }
}
