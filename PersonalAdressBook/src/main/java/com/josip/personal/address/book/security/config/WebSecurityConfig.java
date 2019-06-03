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

/***
 * 
 * @author Josip Bošnjak
 * 
 * <h2>Description</h2>
 * <p>This class configures web security.
 * It defines that a jdbc authentication will be performed, and 
 * also it will be role based with bcrypt password encoder.
 * Also configures http security, that means that
 * form login will be shown, logout will be possible te have,
 * and some post links are protected if user is not authorized,
 * redirect to the login after logout, any request for registration 
 * will have full access to unregistered users. Also, some paths are
 * protected in that way just administrators have access to it.</p>
 *
 */
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
