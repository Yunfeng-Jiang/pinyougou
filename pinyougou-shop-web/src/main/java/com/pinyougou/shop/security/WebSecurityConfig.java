package com.pinyougou.shop.security;

import com.pinyougou.shop.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
/**
 * 启用方法级别的权限认证
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 自定义UserDetailsService，从数据库中读取用户信息
     * @return
     */
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // 必须指定加密方式，否则报错
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    /**
     * 指定加密方式
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    .antMatchers("/static/css/**", "/static/img/**", "/static/js/**", "/static/plugins/**", "/seller/add").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    // 定义当需要用户登录时候，转到的登录页面
                    .loginPage("/shopLogin")
                    .successForwardUrl("/index")
                    .failureForwardUrl("/shopLogin")
                    .permitAll()
                    .and()
                    // 不添加则浏览器无法加载Frame页面报错
                    .headers().frameOptions().disable()
                    .and()
                    .logout().logoutUrl("/logout").logoutSuccessUrl("/shopLogin")
                    .permitAll();
        http.csrf().disable();
    }

}
