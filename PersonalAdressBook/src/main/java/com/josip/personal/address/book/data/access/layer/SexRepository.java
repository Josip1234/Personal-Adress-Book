package com.josip.personal.address.book.data.access.layer;

import com.josip.personal.address.book.presentation.layer.Sex;

/**
 * 
 * @author Josip Bošnjak
 * @since 22.5.2019 9:02
 * @version 1.0
 * 
 * <h2>Description</h2>
 * <p>
 * This interface will be used to store data into database.
 * It contains functions to read, write, update or delete 
 * data from database. Same as the others, except registration.
 * Registration have only one function to register new users into 
 * the database.
 * </p>
 *
 */

public interface SexRepository {
	/**
	 * @author Josip Bošnjak
	 * @since 22.5.2019 14:28
	 * @return list of sex in database
	 *
	 */
    Iterable<Sex> findAll();
    /***
     * @author Josip Bošnjak
     * @since 30.5.2019 17:30
     * @param id -specified id which will be used to find a record in the database.
     * @return one sex record based on id
     */
    Sex findOne(String id);
    Sex save(Sex sex);
    /***
     * @author Josip Bošnjak
     * @since 24.5.2019. 21:10
     * @param sex object data
     * 
     */
    void update(Sex sex);
    /***
     * @author Josip Bošnjak
     * @since 24.5.2019. 21:12
     * @param sex object data
     */
    void delete(Sex sex);
}
