package com.josip.personal.address.book.presentation.layer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
@NotBlank(message= "{fields.required}")
@Size(min=1, max=50, message="{city.name.size}")
private String name;
@NotBlank(message="{fields.required}")
@Size(min=1, max=10, message="{city.zip.size}")
private String zip_code;
@NotBlank(message="{fields.required}")
private Long country_id;

}
