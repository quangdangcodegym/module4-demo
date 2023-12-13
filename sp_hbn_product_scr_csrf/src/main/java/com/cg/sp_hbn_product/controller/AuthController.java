package com.cg.sp_hbn_product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String showLogin(){
        return "login/login";
    }
    @GetMapping("/fail")
    public String showFailLogin(){
        return "login/fail";
    }
}
