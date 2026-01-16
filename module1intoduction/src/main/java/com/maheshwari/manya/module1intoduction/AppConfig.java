package com.maheshwari.manya.module1intoduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    //this method would take priority over other methods like defining bean by using @component or any such other notataions

    @Bean
    @Scope("prototype")
    PaymentService paymentService(){
        //more logic you can put here
        return new PaymentService();
    }
}
