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
	 * @author Josip Bošnjak
	 * @return list of countries
 	 */
Iterable<Country> findAll();
/***
 * @author Josip Bošnjak
 * @param id specified id which will be used to fina a record from the database
 * @return one country based on specified id
 */
Country findOne(String id);
/***
 * @author Josip Bošnjak
 * @param country object data
 * @return country object data
 */
Country save(Country country);
/***
 * @author Josip Bošnjak
 * @param country object data
 */
void update(Country country);
/***
 * @author Josip Bošnjak
 * @param country object data
 */
void delete(Country country);
}
