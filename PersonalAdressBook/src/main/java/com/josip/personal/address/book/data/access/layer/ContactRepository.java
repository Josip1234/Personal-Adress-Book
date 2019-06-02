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
	 * 
	 * @return list of contacts
	 */
Iterable<Contact> findAll();
/***
 * 
 * @param id specified contact id
 * @return contact from database based on specified id
 */
Contact findOne(String id);
/***
 * 
 * @param contact object
 * @return saved object
 */
Contact save(Contact contact);
/***
 * 
 * @param contact object
 */
void update(Contact contact);
/***
 * 
 * @param contact object
 */
void delete(Contact contact);
}
