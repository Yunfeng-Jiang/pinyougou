package com.pinyougou.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <pre>
 *
 * </pre>
 *
 * @author frankJiang
 * @version $ Id: WebSecurityConfig.java, v 0.1 2018/9/19 14:22 frankJiang Exp $
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启security注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // 必须指定加密方式，否则报错
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder()).withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    .antMatchers("/static/css/**", "/static/img/**", "/static/js/**", "/static/plugins/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    // 定义当需要用户登录时候，转到的登录页面
                    .loginPage("/login")
                    .successForwardUrl("/index")
                    .permitAll()
                    .and()
                    // 不添加则浏览器无法加载Frame页面报错
                    .headers().frameOptions().disable()
                    .and()
                    .logout()
                    .permitAll();
        http.csrf().disable();
    }

}
