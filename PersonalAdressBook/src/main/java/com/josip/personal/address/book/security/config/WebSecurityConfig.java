package com.josip.personal.address.book.security.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(
				"SELECT email, password, true FROM users WHERE email=?").passwordEncoder(new BCryptPasswordEncoder()).authoritiesByUsernameQuery(
						"SELECT email, role FROM users WHERE email=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.formLogin().defaultSuccessUrl("/template").and().logout().logoutSuccessUrl("/login").and().rememberMe().and().authorizeRequests().antMatchers("/template").access("hasAnyAuthority('USER','ADMIN')")
		.antMatchers(HttpMethod.POST,"/template/insertSex","/template/insertCountry","/template/insertCity","/template/insertAddress","/template/updateAddress","/template/deleteAddress","/template/insertContact","/template/updateContact","/template/deleteContact").access("hasAnyAuthority('USER','ADMIN')")
		.antMatchers(HttpMethod.POST,"/template/updateSex","/template/deleteSex","/template/updateCountry","/template/deleteCountry","/template/updateCity","/template/deleteCity").access("hasAuthority('ADMIN')")
		.anyRequest().permitAll();
		
	}
	

}
