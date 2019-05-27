package com.josip.personal.address.book.presentation.layer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/***
 * 
 * @author Josip Bošnjak
 * @since 27.5.2019 18:15
 * @version 1.0
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
private Long id;
private String first_name;
private String last_name;
private String phone;
private String email;
private Long sex_id;
private Long address_id;
}
