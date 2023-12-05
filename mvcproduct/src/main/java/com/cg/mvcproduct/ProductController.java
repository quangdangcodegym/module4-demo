package com.cg.mvcproduct;

import com.cg.mvcproduct.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {




    @GetMapping("")
    public String getAllProducts(Model model) {

        model.addAttribute("message", "HELLO EM YÊU");
        return "list";
    }

    @GetMapping("/new-custom")
    public String createProduct(){
        return "create";
    }
    @PostMapping("/new-custom")
    public String insertProduct(@ModelAttribute("product") Product product, BindingResult result, Model model){
        if (product.getName().length() < 5) {
            result.reject("username", null,
                                "There is already an account registered with the same username");
        }
        if (product.getPrice() > 10 || product.getPrice() <0) {
            result.reject("price", null,
                    "Giá trong khoảng từ 0 - 10");
        }
        return "create";
    }

    @GetMapping("/new-validator")
    public String createProductValidator(){
        return "create";
    }
    @PostMapping("/new-validator")
    public String insertProductValidator(@ModelAttribute("product") Product product, BindingResult result, Model model){


        return "create";
    }
}
