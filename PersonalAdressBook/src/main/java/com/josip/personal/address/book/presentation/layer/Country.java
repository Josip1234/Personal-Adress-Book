package com.josip.personal.address.book.presentation.layer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * 
 * @author Josip Bošnjak
 * @version 1.0
 * @since 25.5.2019 19:35
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {
private Long id;
private String name;
private String alpha_2;
private String alpha_3;

}
