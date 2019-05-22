package com.josip.personal.address.book.presentation.layer;

import lombok.AllArgsConstructor;
import lombok.Data;

/***
 * 
 * @author Josip Bošnjak
 * @since 22.5.2019 8:57
 * @version 1.0
 * <strong>
 * This class represent  type of data, getters and setters 
 * which will be used to store data in the database using
 * jdbc driver.
 * </strong>
 */
@Data
@AllArgsConstructor
public class Sex {

	private Long id;
	private String name;
}
