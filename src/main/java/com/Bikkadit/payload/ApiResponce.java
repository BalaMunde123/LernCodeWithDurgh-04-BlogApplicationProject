package com.Bikkadit.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ApiResponce {

	private String message;
	private boolean success;
	public ApiResponce(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}
	
}
