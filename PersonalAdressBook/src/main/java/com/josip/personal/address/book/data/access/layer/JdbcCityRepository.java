package com.josip.personal.address.book.data.access.layer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.josip.personal.address.book.presentation.layer.City;

@Repository
public class JdbcCityRepository implements CityRepository {

	private JdbcTemplate jdbc;
	
	@Autowired
    public JdbcCityRepository(JdbcTemplate template) {
		this.jdbc=template;
	}
	/**
	 * @author Josip Bošnjak
	 * @param rs - cursor which points on the current row of data
	 * @param rowNum - how many data will be returned
	 * @return object data
	 * @throws SQLException if connection is not available
	 */
	private City mapRowToCity(ResultSet rs, int rowNum) throws SQLException{
		return new City(rs.getLong("id"),
				rs.getString("name"),
				rs.getString("zip_code"),
				rs.getLong("country_id"));
	}
	@Override
	public Iterable<City> findAll() {
		
		return jdbc.query("SELECT id,name,zip_code,country_id FROM city", this::mapRowToCity);
	}

	@Override
	public City save(City city) {
		jdbc.update("INSERT INTO city(name,zip_code,country_id) VALUES (?,?,?)", city.getName(),city.getZip_code(),city.getCountry_id());
		return city;
	}

	@Override
	public void update(City city) {
		jdbc.update("UPDATE city SET name=?, zip_code=?, country_id=? WHERE id=?", city.getName(),city.getZip_code(),city.getCountry_id(),city.getId());

	}

	@Override
	public void delete(City city) {
	 jdbc.update("DELETE FROM city WHERE id=?",city.getId());

	}
	@Override
	public City findOne(String id) {
		
		return jdbc.queryForObject("SELECT id,name,zip_code,country_id FROM city WHERE id="+id+"", this::mapRowToCity);
	}

}
