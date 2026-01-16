package com.maheshwari.manya.module1intoduction;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Documented;

//@Component
//@Service
//@Controller
//@Repository
@RestController
public class PaymentService {
    public void pay(){
        System.out.println("Paying....");
    }

    @PostConstruct
    public void afterInit(){
        System.out.println("Before Paying....");
    }

    @PreDestroy
    public void beforeDestroy(){
        System.out.println("After Payment is done...");
    }
}
