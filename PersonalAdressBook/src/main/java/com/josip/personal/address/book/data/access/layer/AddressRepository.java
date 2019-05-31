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
	 * @return list of all adresses
	 */
Iterable<Address> findAll();
Address findOne(String id);
/***
 * 
 * @param address
 * @return adress object
 */
Address save(Address address);
/***
 * 
 * @param address 
 */
void update(Address address);
/***
 * 
 * @param address
 */
void delete(Address address);
}
