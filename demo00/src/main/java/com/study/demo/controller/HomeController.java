package com.study.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * //TODO description end with .
 *
 * @author yanyue, 2019/7/2
 * @version Araf v1.0
 */
@Controller
public class HomeController {
    @RequestMapping({"/","/home","/index"})
    public String index(){
        return "index";
    }
}
