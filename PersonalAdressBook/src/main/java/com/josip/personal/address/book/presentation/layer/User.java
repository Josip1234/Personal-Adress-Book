package com.josip.personal.address.book.presentation.layer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/***
 * 
 * @author Josip Bošnjak
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Long id;
	@NotBlank(message="{fields.required}")
	@Size(min=1,max=20, message="{users.firstName}")
	private String firstName;
	@NotBlank(message="{fields.required}")
	@Size(min=1,max=50, message="{users.lastName}")
	private String lastName;
	@Nullable
	private Integer age;
	@NotBlank(message="{fields.required}")
	@Email(message = "{email.validation}")
	@Size(max=50,message= "{email.size}")
	private String email;
	@NotBlank(message="{fields.required}")
	@Size(min=6,max=50,message= "{password}")
	private String password;
	@Nullable
	private String role;
	


}
