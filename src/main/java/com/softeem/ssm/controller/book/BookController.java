package com.softeem.ssm.controller.book;

import com.softeem.ssm.pojo.User;
import com.softeem.ssm.pojo.UserVo;
import com.softeem.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/bookController")
public class BookController {
    @Autowired
    private UserService userService;

    public String login(User user,HttpSession session, Model model){
        UserVo myuser = userService.login(user);
        if(myuser!=null){
            session.setAttribute("myuser",myuser);
            return "book/main";
        }
        else{
            model.addAttribute("msg","用户名或密码错误");
            return "book/login";
        }

    }
}
