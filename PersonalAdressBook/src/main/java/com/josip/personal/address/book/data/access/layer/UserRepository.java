package com.josip.personal.address.book.data.access.layer;

import com.josip.personal.address.book.presentation.layer.User;

/***
 * 
 * @author Josip Bošnjak
 * @since 2.6.2019 16:24
 *
 */
public interface UserRepository {
	/***
	 * 
	 * @param user object which will be used to be saved into the database.
	 */
public void register(User user);
}
