package com.study.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * AdminController .
 *
 * @author yanyue, 2019/7/3
 * @version spring-security v1.0
 */
@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String admin(@AuthenticationPrincipal Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "/admin/admin";
    }
}
