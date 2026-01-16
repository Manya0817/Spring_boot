package com.maheshwari.manya.module1intoduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module1intoductionApplication implements CommandLineRunner {

    @Autowired
    PaymentService paymentServiceOb1;

    @Autowired
    PaymentService paymentServiceOb2;

	public static void main(String[] args) {
		SpringApplication.run(Module1intoductionApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println(paymentServiceOb1.hashCode());
        System.out.println(paymentServiceOb2.hashCode());
        paymentServiceOb1.pay();
        paymentServiceOb2.pay();
    }
}
