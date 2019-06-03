package com.josip.personal.address.book.data.access.layer;
/***
 * 
 * @author Josip Bošnjak
 * @since 27.5.2019
 * @version 1.0
 *
 */

import com.josip.personal.address.book.presentation.layer.Address;

public interface AddressRepository {
	/***
	 * @author Josip Bošnjak
	 * @return list of all addresses
	 */
Iterable<Address> findAll();
/***
 * @author Josip Bošnjak
 * @param id what address to find with specified id
 * @return one address
 */
/***
 * @author Josip Bošnjak
 * @param id -which will be used to find a specified record from the database
 * @return address object data
 */
Address findOne(String id);
/***
 * @author Josip Bošnjak
 * @param address -object data
 * @return address -object data
 */
Address save(Address address);
/***
 * @author Josip Bošnjak
 * @param address -object data
 */
void update(Address address);
/***
 * @author Josip Bošnjak
 * @param address -object data
 */
void delete(Address address);
}
