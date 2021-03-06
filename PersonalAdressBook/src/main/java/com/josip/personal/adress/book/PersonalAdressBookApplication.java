package com.josip.personal.adress.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/***
 * 
 * @author Josip Bošnjak
 * 
 * <h2>Description</h2>
 * <p>This is not regular spring boot class. 
 * Spring boot servlet initializer is extended because it 
 * needs to enable old war package use. Servlet is defined
 * in application.properties file.</p>
 *
 */
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = {"com.josip"})
public class PersonalAdressBookApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder personalAdressBookApplication) {
		return personalAdressBookApplication.sources(PersonalAdressBookApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(PersonalAdressBookApplication.class, args);
	}
	
	

}
