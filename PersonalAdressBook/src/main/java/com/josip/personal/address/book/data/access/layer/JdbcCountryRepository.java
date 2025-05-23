package com.josip.personal.address.book.data.access.layer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.josip.personal.address.book.presentation.layer.Country;

@Repository
public class JdbcCountryRepository implements CountryRepository {
	private JdbcTemplate jdbc;

	public JdbcCountryRepository(JdbcTemplate jdbcTemplate) {
		this.jdbc=jdbcTemplate;
	}
	/**
	 * @author Josip Bošnjak
	 * @param rs - cursor which points on the current row of data
	 * @param rowNum - how many data will be returned
	 * @return object data
	 * @throws SQLException if connection is not available
	 */
	private Country mapRowToCountry(ResultSet rs, int rowNum) throws SQLException{
		return new Country(rs.getLong("id"),
				rs.getString("name"),
				rs.getString("alpha_2"),
				rs.getString("alpha_3"));
	}
	@Override
	public Iterable<Country> findAll() {
		
		return jdbc.query("SELECT id,name,alpha_2,alpha_3 FROM country", this::mapRowToCountry);
	}

	@Override
	public Country save(Country country) {
		jdbc.update("INSERT INTO country(name,alpha_2,alpha_3) VALUES (?,?,?)",
				country.getName(),country.getAlpha_2(),country.getAlpha_3());
		return country;
	}

	@Override
	public void update(Country country) {
		jdbc.update("UPDATE country SET name=?,alpha_2=?,alpha_3=? WHERE id=?",
				country.getName(),country.getAlpha_2(),country.getAlpha_3(),country.getId());

	}

	@Override
	public void delete(Country country) {
		jdbc.update("DELETE FROM country WHERE id=?", country.getId());

	}
	@Override
	public Country findOne(String id) {
		return jdbc.queryForObject("SELECT id,name,alpha_2,alpha_3 FROM country WHERE id="+id+"", this::mapRowToCountry);
	}

}
