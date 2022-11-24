package com.softeem.ssm.controller;

import com.softeem.ssm.pojo.Role;
import com.softeem.ssm.pojo.User;
import com.softeem.ssm.service.RoleService;
import com.softeem.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/userController")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("userList",userList);
        return "auth/findUser";
    }
    @RequestMapping("/configuredRole")
    public String configuredRole(Model model,Integer uid){

        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList",roleList);
        model.addAttribute("uid",uid);
       String rids = userService.findUserByUid(uid);
        model.addAttribute("rids",rids);

        return "auth/configuredRole";
    }

    @RequestMapping("/saveUserRoleMapping")
    public String saveUserRoleMapping(Integer[] rid,Integer uid,Model model){
        userService.saveUserRoleMapping(rid,uid);
        return this.findAll(model);
    }
}
