package com.josip.personal.address.book.data.access.layer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.josip.personal.address.book.presentation.layer.User;

@Repository
public class JdbcUserRepository implements UserRepository {
    private JdbcTemplate jdbcTemplate;
    
    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	@Override
	public void register(User user) {
		jdbcTemplate.update("INSERT INTO users(firstName,lastName, age, email, password, role) VALUES(?,?,?,?,?,?)",user.getFirstName(),user.getLastName(),user.getAge(),user.getEmail(),user.getPassword(),user.getRole());

	}

}
