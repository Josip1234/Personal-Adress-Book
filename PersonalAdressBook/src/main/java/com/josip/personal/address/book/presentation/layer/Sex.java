package com.josip.personal.address.book.presentation.layer;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * 
 * @author Josip Bošnjak
 * @since 22.5.2019 8:57
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sex {

	
	private Long id;
	@NotNull
	@Size(min=1, max=7, message="{sex.name.size}")
	private String name;
}
