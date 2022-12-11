package com.Bikkadit.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class UserDto {
	
	private int id;
	@NotEmpty
	@Size(min=4,message ="username must be min 4 characters!!!")
	private String name;
	@Email(message ="Emailid not valid!!!")
	private String email;
	@NotEmpty()
	@Size(min=3,max =10,message = "password must be min 3 character and max 10 charater !!!!!")
	 
	private String password;
	@NotEmpty
	private String about;
	
}
