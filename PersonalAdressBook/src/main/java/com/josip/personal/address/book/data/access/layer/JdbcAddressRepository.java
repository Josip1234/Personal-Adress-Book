package com.josip.personal.address.book.data.access.layer;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.josip.personal.address.book.presentation.layer.Address;
@Repository
public class JdbcAddressRepository implements AddressRepository {
     //jdbc template is built in java managed core package. It simplifies use of database.
	private JdbcTemplate jdbc;
	
	public JdbcAddressRepository(JdbcTemplate jdbcTemplate) {
		this.jdbc=jdbcTemplate;
	}
	/**
	 * @author Josip Bošnjak
	 * @param rs - cursor which points on the current row of data
	 * @param rowNum - how many data will be returned
	 * @return object data
	 * @throws SQLException if connection is not available
	 */
	private Address mapRowToAddress(ResultSet rs, int rowNum) throws SQLException{
		return new Address(
				rs.getLong("id"),
				rs.getString("street"),
				rs.getString("street_no"),
				rs.getLong("city_id")
				);
	}
	@Override
	public Iterable<Address> findAll() {
		
		return jdbc.query("SELECT id, street, street_no, city_id FROM address", this::mapRowToAddress);
	}

	@Override
	public Address save(Address address) {
		jdbc.update("INSERT INTO address(street, street_no, city_id) VALUES (?,?,?)",address.getStreet(),address.getStreet_no(),address.getCity_id());
		return address;
	}

	@Override
	public void update(Address address) {
		jdbc.update("UPDATE address SET street=?, street_no=?, city_id=? WHERE id=?", address.getStreet(), address.getStreet_no(),address.getCity_id(),address.getId());

	}

	@Override
	public void delete(Address address) {
		jdbc.update("DELETE FROM address WHERE id=?", address.getId());

	}
	@Override
	public Address findOne(String id) {
		
		return jdbc.queryForObject("SELECT id, street, street_no, city_id FROM address WHERE id="+id+"", this::mapRowToAddress);
	}

}
