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
Iterable<Country> findAll();
Country findOne(String id);
Country save(Country country);
void update(Country country);
void delete(Country country);
}
