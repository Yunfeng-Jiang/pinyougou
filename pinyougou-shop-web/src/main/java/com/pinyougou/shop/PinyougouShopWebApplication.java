package com.pinyougou.shop;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;


@ComponentScan(basePackages = {"com.pinyougou"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@MapperScan(basePackages = "com.pinyougou.mapper")
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)// 解决jmx重复注册bean的问题
@Import(FdfsClientConfig.class)//注解，就可以拥有带有连接池的FastDFS Java客户端了
public class PinyougouShopWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PinyougouShopWebApplication.class, args);
        System.out.println("~~~~~~pinyougou-shop-web 启动成功！~~~~~~~");
    }
}
