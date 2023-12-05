package com.cg.mvcproduct;

import com.cg.mvcproduct.model.IUserService;
import com.cg.mvcproduct.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    @Qualifier("user1Service")
    private IUserService abcUser;

    @GetMapping("")
    public String getAllProducts(Model model) {

        abcUser.sayHello();
        System.out.println(abcUser.toString());
        model.addAttribute("message", "HELLO EM YÊU");
        return "list";
    }
}
