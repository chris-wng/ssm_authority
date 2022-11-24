package com.softeem.ssm.controller;

import com.softeem.ssm.pojo.Auth;
import com.softeem.ssm.pojo.Role;
import com.softeem.ssm.service.AuthService;
import com.softeem.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/roleController")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthService authService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList" , roleList);
        return "auth/findRole";

    }
    @RequestMapping("/configuredAuth")
    public String configuredAuth(Integer rid,Model model){
        model.addAttribute("rid",rid);
        List<Auth> authList = authService.findAll();
        model.addAttribute("authList",authList);
        String aids = roleService.findRoleByRid(rid);
        model.addAttribute("aids",aids);
        return "auth/configuredAuth";
    }


    @RequestMapping("/savaRoleAuthMapping")
    public String savaRoleAuthMapping(Integer[] aid,Integer rid,Model model){
        roleService.savaRoleAuthMapping(aid, rid);
        return this.findAll(model);
    }
}
