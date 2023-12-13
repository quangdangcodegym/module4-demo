package com.cg.sp_hbn_product.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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


    @PostMapping("/mylogin")
    public String processLogin(UserDTO userDTO){
        System.out.println(userDTO);

        return "";
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class UserDTO{
        private String username;
        private String password;
    }
}
