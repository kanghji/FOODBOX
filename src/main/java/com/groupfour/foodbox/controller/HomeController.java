package com.groupfour.foodbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/test")
public class HomeController {
    @RequestMapping("/")
    public String root(){

        return "/home";
    }
}