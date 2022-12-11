package com.Bikkadit.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CategoryDto {
	private int categoryid;
	@NotBlank
	@Size(min =4,message ="min size of categorytitle is 4!!!!!")
	private String categorytitle;
	@NotBlank
	@Size(min =10,message ="min size of category Description is 10!!!!")
	private String Categorydescription;


}
