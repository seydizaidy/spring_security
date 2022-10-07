package com.zaidy.entitiesDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@FieldMatch.List({
//		@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
//		@FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
//})
@Data @NoArgsConstructor @AllArgsConstructor
public class UserRegistrationDto {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	

}
