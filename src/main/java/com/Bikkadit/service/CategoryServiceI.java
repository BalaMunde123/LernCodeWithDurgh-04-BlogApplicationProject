package com.Bikkadit.service;

import java.util.List;

import com.Bikkadit.payload.CategoryDto;

public interface CategoryServiceI {
	
	//1 create
	public CategoryDto createcategory(CategoryDto catdto);
	//2 update 
	public CategoryDto updateCategory(CategoryDto catdto,int categoryid);
	//3 delete
	public void deletebyId(int categoryid);
	//4 getbyid
	public CategoryDto getbycatId(int categoryid);
	
	//5 getall
	public List<CategoryDto> getAllCategory();
	

}
