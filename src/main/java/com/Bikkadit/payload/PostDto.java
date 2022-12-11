package com.Bikkadit.payload;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
public class PostDto {
	private int postid;
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;   
	
	private CategoryDto category;
	
	private UserDto user;

}
