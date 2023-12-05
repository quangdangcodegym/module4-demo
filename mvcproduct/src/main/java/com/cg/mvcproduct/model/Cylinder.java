package com.cg.mvcproduct.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cylinder {
    @Autowired
    private Circle circle;

    public Cylinder(Circle circle) {
        this.circle = circle;
    }

}
