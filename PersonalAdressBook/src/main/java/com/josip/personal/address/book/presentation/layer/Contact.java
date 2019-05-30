package com.josip.personal.address.book.presentation.layer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
@NotBlank(message="{fields.required}")
@Size(min=1,max=20,message= "{contact.first.size}")
private String first_name;
@NotBlank(message="{fields.required}")
@Size(min=1,max=50,message= "{contact.last.size}")
private String last_name;
@NotBlank(message="{fields.required}")
@Size(min=1,max=13,message= "{contact.phone.size}")
private String phone;
@NotBlank(message="{fields.required}")
@Email(message = "{email.validation}")
@Size(max=50,message= "{email.size}")
private String email;

private Long sex_id;

private Long address_id;
}
