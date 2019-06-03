package com.josip.personal.address.book.data.access.layer;

import com.josip.personal.address.book.presentation.layer.City;
/***
 * 
 * @author Josip Bošnjak
 * @version 1.0
 * @since 26.5.2019 16:17
 */
public interface CityRepository {
	/**
	 * @author Josip Bošnjak
	 * @return list of cities
	 */
Iterable<City> findAll();
/***
 * @author Josip Bošnjak
 * @param id -which will be used to fina a record from the database
 * @return one city record
 */
City findOne(String id);
/***
 * @author Josip Bošnjak
 * @param city -object data
 * @return city -object data
 */
City save(City city);
/***
 * @author Josip Bošnjak
 * @param city -object data
 */
void update(City city);
/***
 * @author Josip Bošnjak
 * @param city -object data
 */
void delete(City city);
}
