package com.josip.personal.address.book.data.access.layer;
/***
 * 
 * @author Josip Bošnjak
 * @version 1.0
 * @since 25.5.2019 19:44
 * 
 *
 */

import com.josip.personal.address.book.presentation.layer.Country;

public interface CountryRepository {
	/***
	 * 
	 * @return list of countries
 	 */
Iterable<Country> findAll();
/***
 * 
 * @param id
 * @return one country based on specified id
 */
Country findOne(String id);
/***
 * 
 * @param country
 * @return country object
 */
Country save(Country country);
/***
 * 
 * @param country object to update
 */
void update(Country country);
/***
 * 
 * @param country object to delete
 */
void delete(Country country);
}
