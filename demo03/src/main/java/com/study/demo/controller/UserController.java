package com.study.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * //TODO description end with .
 *
 * @author yanyue, 2019/7/5
 * @version Araf v1.0
 */

@Controller
public class UserController {

    @RequestMapping("/user")
    public String index(@AuthenticationPrincipal Principal principal, Model model){
        model.addAttribute("username",principal.getName());
        return "/user/user";
    }
}
