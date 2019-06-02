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
	 * 
	 * @return list of all addresses
	 */
Iterable<Address> findAll();
/***
 * 
 * @param id what address to find with specified id
 * @return one address
 */
Address findOne(String id);
/***
 * 
 * @param address object
 * @return adress object
 */
Address save(Address address);
/***
 * 
 * @param address object
 */
void update(Address address);
/***
 * 
 * @param address object
 */
void delete(Address address);
}
