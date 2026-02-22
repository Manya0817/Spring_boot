package com.homeWork.module4Hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Module4HwApplication {

	public static void main(String[] args) {
		SpringApplication.run(Module4HwApplication.class, args);
	}

}
