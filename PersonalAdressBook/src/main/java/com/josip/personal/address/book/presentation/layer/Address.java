package com.josip.personal.address.book.presentation.layer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
@NotBlank(message="{fields.required}")
@Size(min=1,max=50,message="{address.street.size}")
private String street;
@NotBlank(message="{fields.required}")
@Size(min=1,max=5,message="{address.street.number}")
private String street_no;
private Long city_id;
}
