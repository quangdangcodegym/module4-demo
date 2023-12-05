package com.cg.mvcproduct.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class User1Service implements IUserService{

    // bean: user1Service =  new User1Service()
    @Override
    public void sayHello() {
        System.out.println("User1Service say Hello");
    }
}
