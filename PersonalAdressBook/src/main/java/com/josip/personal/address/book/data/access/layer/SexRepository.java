package com.josip.personal.address.book.data.access.layer;

import com.josip.personal.address.book.presentation.layer.Sex;

/**
 * 
 * @author Josip Bošnjak
 * @since 22.5.2019 9:02
 * @version 1.0
 * 
 * <strong>
 * This interface will be used to store data into database.
 * It contains functions to read, write, update or delete 
 * data from database.
 * </strong>
 *
 */
public interface SexRepository {
    Iterable<Sex> findAll();
}
