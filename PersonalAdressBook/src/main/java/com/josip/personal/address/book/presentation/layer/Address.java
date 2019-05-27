package com.josip.personal.address.book.presentation.layer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/***
 * 
 * @author Josip Bošnjak
 * @since 27.5.2019 15:11
 * @version 1.0
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
private Long id;
private String street;
private String street_no;
private Long city_id;
}
