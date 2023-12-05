package com.cg.mvcproduct;

import com.cg.mvcproduct.model.Circle;
import com.cg.mvcproduct.model.Cylinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class AppConfig {

    @Bean
    public Circle getCircle(){
        return new Circle(5);
    }



}
