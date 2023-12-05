package com.cg.mvcproduct;

import com.cg.mvcproduct.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Controller
@RequestMapping("/products")
public class ProductController {

    @GetMapping("")
    public String getAllProducts(Model model) {
        model.addAttribute("message", "HELLO EM YÊU");
        return "list";
    }
    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @GetMapping("/new-custom")
    public String createProduct(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "create";
    }
    @PostMapping("/new-custom")
    public String insertProduct(@ModelAttribute("product") Product product, BindingResult result, Model model){
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        product.setId(null);
//        entityManager.persist(product);
//
//        entityManager.getTransaction().commit();
        if (product.getName().length() > 5) {
            result.rejectValue("name", "name");
        }
        if (product.getPrice() <10) {
            result.rejectValue("price", "price");
        }
        return "create";
    }

    @GetMapping("/new-validator")
    public String createProductValidator(Model model){

        Product product = new Product();
        model.addAttribute("product", product);
        return "create-validator";
    }
    @PostMapping("/new-validator")
    public String insertProductValidator(@Validated @ModelAttribute("product") Product product, BindingResult result, Model model){
        new Product().validate(product, result);

        return "create-validator";
    }


}
