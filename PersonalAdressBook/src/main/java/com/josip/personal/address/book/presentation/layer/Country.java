package com.josip.personal.address.book.presentation.layer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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
@NotBlank(message= "{fields.required}")
@Size(min=1, max=50, message="{country.name.size}")
private String name;
@NotBlank(message= "{fields.required}")
@Size(min=1, max=2, message="{country.size.alpha}")
private String alpha_2;
@NotBlank(message= "{fields.required}")
@Size(min=1, max=3, message="{country.size.alpha}")
private String alpha_3;

}
