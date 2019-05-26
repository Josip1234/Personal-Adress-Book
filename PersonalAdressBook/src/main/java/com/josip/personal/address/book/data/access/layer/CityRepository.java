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
	 * 
	 * @return list of cities
	 */
Iterable<City> findAll();
/***
 * 
 * @param city object
 * @return city object
 */
City save(City city);
/***
 * 
 * @param city object
 */
void update(City city);
/***
 * 
 * @param city object
 */
void delete(City city);
}
