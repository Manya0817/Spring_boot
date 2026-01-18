package com.maheshwari.manya.module1intoduction;

import com.maheshwari.manya.module1intoduction.impl.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Module1intoductionApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(Module1intoductionApplication.class, args);
	}

    //@Autowired ->FIELD dependency injection

//    final NotificationService notificationServiceObj; //here we are injecting dependency
//
//   @Qualifier('smsNotif')
//    public Module1intoductionApplication( NotificationService notificationServiceObj){
//        this.notificationServiceObj=notificationServiceObj; //this is constructor dependency injection
//        //Preferred way of doing injection
//    }
    @Autowired
    Map<String, NotificationService> notificationServiceMap=new HashMap<>();

    @Override
    public void run(String... args) throws Exception {
        //notificationServiceObj=new EmailNotificationService();
//        notificationServiceObj.send("Hello");
        for(var notificationService:notificationServiceMap.entrySet()){
            System.out.println(notificationService.getKey());
            notificationService.getValue().send("Hello");
        }
    }
}
