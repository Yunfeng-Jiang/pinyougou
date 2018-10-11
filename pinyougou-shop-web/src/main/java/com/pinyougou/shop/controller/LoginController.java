package com.pinyougou.shop.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *  主页显示登录名
 * </pre>
 *
 * @author frankJiang
 * @version $ Id: LoginController.java, v 0.1 2018/9/19 14:45 frankJiang Exp $
 */
@RestController
@RequestMapping("/loginName")
public class LoginController {

    @RequestMapping("name")
    public Map name() {
        String name = SecurityContextHolder.getContext()
                .getAuthentication().getName();
        HashMap<String, String> map = new HashMap<>(2);
        map.put("loginName", name);
        return map ;
    }


}
