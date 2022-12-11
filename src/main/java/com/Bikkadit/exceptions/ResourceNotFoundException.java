package com.Bikkadit.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException {
	String resourcename;
	String fieldname;
	long filedValue;
	public ResourceNotFoundException(String resourcename, String fieldname, long filedValue) {
		super(String.format("%s not found with %s:%s", resourcename,fieldname,filedValue));
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.filedValue = filedValue;
	}
	
	
	

	
	


}
