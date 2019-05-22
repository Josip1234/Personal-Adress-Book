package com.josip.personal.address.book.data.access.layer;

import org.springframework.stereotype.Repository;

import com.josip.personal.address.book.presentation.layer.Sex;

/**
 * 
 * @author Josip Bošnjak
 * @since 22.5.2019 9:02
 * @version 1.0
 * 
 * <strong>
 * This interface will be used to store data into database.
 * It contains functions to read, write, update or delete 
 * data from database.
 * </strong>
 *
 */

public interface SexRepository {
	/**
	 * @author Josip Bošnjak
	 * @since 22.5.2019 14:28
	 * @return list of sex in database
	 * 
	 * <h2>Description</h2>
	 * <strong>
	 * The query() method accepts the SQL for the query as well as an implementation of Spring’s RowMapper for the purpose of mapping each row in the result set to
        an object. findAll() also accepts as its final argument(s) a list of any parameters required in the query.
        RowMapper parameter for both findAll() is given as a method reference to the mapRowToIngredient() method. Java 8’s
        method references and lambdas are convenient when working with JdbcTemplate as
        an alternative to an explicit RowMapper implementation.
	 * </strong>
	 */
    Iterable<Sex> findAll();
    /**
     * @author Josip Bošnjak
     * @since 22.5.2019 14:28
     * @param sex 
     * @return saves object into database
     * 
     * <h2>Description</h2>
     * <strong>
     * Because it is not necessary to map result set data to an object,
     * the update() method is much simpler than query() or queryForObject().
     * It only requires a string containing the sql to perform as well as 
     * values to assign to any query parameters. Query has one parameter.
     * </strong>
     */
    Sex save(Sex sex);
}
