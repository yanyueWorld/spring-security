package com.study.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HomeController.
 *
 * @author yanyue, 2019/7/3
 * @version spring-security v1.0
 */
@Controller
public class HomeController {

    @RequestMapping({"/","/home","/index"})
    public String root(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

}
