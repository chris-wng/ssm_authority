package com.softeem.ssm.controller;

import com.softeem.ssm.pojo.Auth;
import com.softeem.ssm.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/authController")
public class AuthController {
    @Autowired
    private AuthService authService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Auth> authList = authService.findAll();
        model.addAttribute("authList",authList);
        return "auth/findAuth";
    }
}
