package com.josip.personal.address.book.presentation.layer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * 
 * @author Josip Bošnjak
 * @version 1.0
 * @since 26.5.2019 16:08
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
private Long id;
private String name;
private String zip_code;
private Long country_id;

}
