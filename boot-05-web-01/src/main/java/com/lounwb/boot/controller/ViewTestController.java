package com.lounwb.boot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewTestController {

    @GetMapping("/view")
    public String view(Model model){
        model.addAttribute("msg","this is a message");
        model.addAttribute("link", "http://www.baidu.com");
        return "success";
    }
}
