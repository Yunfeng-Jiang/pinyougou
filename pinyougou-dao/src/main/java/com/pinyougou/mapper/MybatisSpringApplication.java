package com.pinyougou.mapper; /**
 * e-BuyChina.com.cn Inc.
 * Copyright (c) 2006-2018 All Rights Reserved.
 */
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pinyougou.mapper")
public class MybatisSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisSpringApplication.class, args);
        System.out.println("~~~~~~pinyougoudao~~~~~启动成功！");
    }

}