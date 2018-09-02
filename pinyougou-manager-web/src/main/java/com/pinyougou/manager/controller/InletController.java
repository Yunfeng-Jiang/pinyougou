package com.pinyougou.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面入口跳转Controller
 */
@Controller
public class InletController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
	public String index() {
        return "admin/index";
	}

    @RequestMapping("/home")
    public String home() {
        return "admin/home";
    }

    @RequestMapping("/brand")
    public String brand() {
        return "admin/brand";
    }

}
