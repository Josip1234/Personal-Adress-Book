package com.josip.personal.adress.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.josip.personal.adress")
@SpringBootApplication
public class PersonalAdressBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalAdressBookApplication.class, args);
	}

}
