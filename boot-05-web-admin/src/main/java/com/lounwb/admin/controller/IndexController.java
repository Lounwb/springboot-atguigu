package com.lounwb.admin.controller;

import com.lounwb.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if (!StringUtils.isEmpty(user.getUsername()) && "123456".equals(user.getPassword())){
            session.setAttribute("loginUser", user);
            //登陆成功，重定向到main.html
            return "redirect:/main.html";
        }
        model.addAttribute("msg","账号密码错误");
        return "login";
    }

    /**
     * go to main Page
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        return "main";
    }
}