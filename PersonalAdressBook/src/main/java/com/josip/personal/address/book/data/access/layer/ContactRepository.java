package com.josip.personal.address.book.data.access.layer;
/***
 * 
 * @author Josip Bošnjak
 * @since 27.5.2019 18:16
 * @version 1.0
 *
 */

import com.josip.personal.address.book.presentation.layer.Contact;

public interface ContactRepository {
	/***
	 * @author Josip Bošnjak
	 * @return list of contacts
	 */
Iterable<Contact> findAll();
/***
 * @author Josip Bošnjak
 * @param id specified contact id
 * @return contact from database based on specified id
 */
Contact findOne(String id);
/***
 * @author Josip Bošnjak
 * @param contact -object data
 * @return contact object data
 */
Contact save(Contact contact);
/***
 * @author Josip Bošnjak
 * @param contact object data
 */
void update(Contact contact);
/***
 * @author Josip Bošnjak
 * @param contact object data
 */
void delete(Contact contact);
}
