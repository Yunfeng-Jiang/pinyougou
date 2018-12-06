package com.pinyougou.shop.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/index")
    public String index() {
        return "admin/index";
    }

    @RequestMapping("/home")
    public String home() {
        return "admin/home";
    }

    @RequestMapping("/addGood")
    public String addGood(Model model, @RequestParam(value = "id", required = false, defaultValue = "") String id) {
        if (StringUtils.isNotEmpty(id)) {
            model.addAttribute("id", id);
        }
        return "admin/goods_edit";
    }

    @RequestMapping("/goods")
    public String goods() {
        return "admin/goods";
    }


}
