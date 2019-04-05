package com.validation.ValidationOfUser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg.capstore")
@EntityScan("com.cg.capstore.bean")
public class ValidationOfUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidationOfUserApplication.class, args);
	}

}
