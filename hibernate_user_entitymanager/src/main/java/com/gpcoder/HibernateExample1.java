package com.gpcoder;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.gpcoder.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateExample1 {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        User u = new User();
        u.setUsername("Quang DAng");
        u.setPassword("123123");

        entityManager.persist(u);
        entityManager.getTransaction().commit();
    }
}