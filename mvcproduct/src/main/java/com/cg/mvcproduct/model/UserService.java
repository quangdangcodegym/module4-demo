package com.cg.mvcproduct.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("xxxUser")
public class UserService implements IUserService{
    @Override
    public void sayHello() {
        System.out.println("UserService say Helloxxxxxxxxxx");
    }
}
