package com.example.demo;


import com.example.demo.model.productRegistry.Application;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        Configuration configuration = new Configuration().addAnnotatedClass(Object.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            new Application();
//            session.beginTransaction();
//            TableDAO tmp = new TableDAO(sessionFactory);
//            tmp.index();
        }
    }
    }


