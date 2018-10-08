package com.pinyougou.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面入口跳转Controller
 */
@Controller
public class InletController {

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/shopLogin")
    public String shopLogin() {
        return "shoplogin";
    }

}
