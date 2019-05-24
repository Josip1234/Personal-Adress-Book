package com.josip.personal.address.book.data.access.layer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.josip.personal.address.book.presentation.layer.Sex;

/***
 * 
 * @author Josip Bošnjak
 * @version 1.0
 * @since 22.5.2019 9:07
 * 
 * <strong>
 * This class implements sex repository interface functions.
 * It will inject jdbc template and it is annotated as repository.
 * It means that this will automatically be discovered by spring component 
 * scanning and be declared as a bean in the spring application context.
 * When bean is being created, it inject it with jdbc template via @Autowired  
 * annotated constructor. This constructor assigns jdbc template to be
 * an instance variable that will be used in ther methods to query and to 
 * insert into database.
 * 
 *  </strong>
 *
 */
@Repository
public class JdbcSexRepository implements SexRepository {

	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcSexRepository(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}
	
	@Override
	public Iterable<Sex> findAll() {
		
  		return jdbc.query("SELECT id,name FROM sex", this::mapRowToSex);
  		
	}

	private Sex mapRowToSex(ResultSet rs, int rowNum) throws SQLException{
		return new Sex(rs.getLong("id"),
				rs.getString("name"));
	}

	@Override
	public Sex save(Sex sex) {
		jdbc.update(
				"INSERT INTO sex(name) VALUES (?)", 
				sex.getName());
		return sex;
	}

	@Override
	public void update(Sex sex) {
	    
	    jdbc.update("UPDATE sex set name=? where id=?", sex.getName(),sex.getId());
	
	}

	@Override
	public void delete(Sex sex) {
	    jdbc.update("DELETE id,name FROM sex WHERE id=?",sex.getId());
	}
}
