package com.Bikkadit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Bikkadit.payload.ApiResponce;
import com.Bikkadit.payload.CategoryDto;
import com.Bikkadit.service.CategoryServiceI;



@RestController
public class CategoryController {
	@Autowired
	private CategoryServiceI categoryServiceI;
	
	//create
	@PostMapping(value ="/createcategory")
	public ResponseEntity<CategoryDto> createCategory(@Valid@RequestBody CategoryDto catdto) {
		CategoryDto categoryDto = this.categoryServiceI.createcategory(catdto);
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.CREATED);
		
	}
	//update
	@PutMapping(value ="/updatecategory/{categoryId}")
	public ResponseEntity<CategoryDto> udatecategory(@Valid@RequestBody CategoryDto catdto,@PathVariable int categoryId){
		CategoryDto categoryDto = this.categoryServiceI.updateCategory(catdto, categoryId);
		
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
		
	}
	//delete
	@DeleteMapping(value ="/deletecategory/{categoryId}")
	public ResponseEntity<ApiResponce> deleteCategorybyid(@PathVariable int categoryId) {
		this.categoryServiceI.deletebyId(categoryId);
		return new ResponseEntity<ApiResponce>(new ApiResponce("Category Deleted Successfully!!!!",true),HttpStatus.OK);
	}
	//getbyid
	@GetMapping(value ="/getcategory/{categoryId}")
	public ResponseEntity<CategoryDto> getcategory(@PathVariable int categoryId){
		CategoryDto categoryDto = this.categoryServiceI.getbycatId(categoryId);
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
		
	}
	//getAll
	@GetMapping("/getallcategory")
public ResponseEntity<List<CategoryDto>> getAllCategory(){
	List<CategoryDto> allCategory = this.categoryServiceI.getAllCategory();
	return new ResponseEntity<List<CategoryDto>>(allCategory,HttpStatus.OK);
	
}
}
