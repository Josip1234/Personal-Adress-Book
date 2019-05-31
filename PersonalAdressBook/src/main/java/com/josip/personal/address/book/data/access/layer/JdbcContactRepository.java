package com.josip.personal.address.book.data.access.layer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.josip.personal.address.book.presentation.layer.Contact;

@Repository
public class JdbcContactRepository implements ContactRepository{
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcContactRepository(JdbcTemplate template) {
		this.jdbc=template;
	}
	private Contact mapRowToContact(ResultSet rs, int rowNum) throws SQLException {
		return new Contact(rs.getLong("id"),
				rs.getString("first_name"),
				rs.getString("last_name"),
				rs.getString("phone"),
				rs.getString("email"),
				rs.getLong("sex_id"),
				rs.getLong("address_id"));
	}

	@Override
	public Iterable<Contact> findAll() {
		
		return jdbc.query("SELECT id, first_name,last_name,phone,email,sex_id,address_id FROM contact", this::mapRowToContact);
	}

	@Override
	public Contact save(Contact contact) {
		jdbc.update("INSERT INTO contact(first_name,last_name,phone,email,sex_id,address_id) VALUES (?,?,?,?,?,?)", contact.getFirst_name(),contact.getLast_name(),contact.getPhone(),contact.getEmail(),contact.getSex_id(),contact.getAddress_id());
		return contact;
	}

	@Override
	public void update(Contact contact) {
		jdbc.update("UPDATE contact SET first_name=?, last_name=?, phone=?, email=?, sex_id=?, address_id=? WHERE id=?", contact.getFirst_name(),contact.getLast_name(),contact.getPhone(),contact.getEmail(),contact.getSex_id(),contact.getAddress_id(),contact.getId());
		
	}

	@Override
	public void delete(Contact contact) {
		jdbc.update("DELETE FROM contact WHERE id=?",contact.getId());
		
	}
	@Override
	public Contact findOne(String id) {
		
		return jdbc.queryForObject("SELECT id, first_name,last_name,phone,email,sex_id,address_id FROM contact WHERE id="+id+"", this::mapRowToContact);
	}

}
