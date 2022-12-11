package com.Bikkadit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bikkadit.entities.Category;
import com.Bikkadit.exceptions.ResourceNotFoundException;
import com.Bikkadit.payload.CategoryDto;
import com.Bikkadit.repository.CategoryRepository;

@Service
public class CategorySeviceImpl implements CategoryServiceI {
    @Autowired
	private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    //1create
	@Override
	public CategoryDto createcategory(CategoryDto catdto) {
		Category category = this.modelMapper.map(catdto, Category.class);
		Category category2 = this.categoryRepository.save(category);
		
		return this.modelMapper.map(category2, CategoryDto.class);
	}
	//2update
	@Override
	public CategoryDto updateCategory(CategoryDto catdto, int categoryid) {
		Category category = this.categoryRepository.findById(categoryid).orElseThrow(()->new ResourceNotFoundException("Category","category id", categoryid));
		category.setCategorytitle(catdto.getCategorytitle());
		category.setCategorydescription(catdto.getCategorydescription());
		Category newcategory = this.categoryRepository.save(category);
		return this.modelMapper.map(newcategory, CategoryDto.class);
	}
	//3delete
	@Override
	public void deletebyId(int categoryid) {
		Category category = this.categoryRepository.findById(categoryid).orElseThrow(()->new ResourceNotFoundException("Category","category id", categoryid));
		this.categoryRepository.delete(category);
		}
	//get
	@Override
	public CategoryDto getbycatId(int categoryid) {
		Category category = this.categoryRepository.findById(categoryid).orElseThrow(()->new ResourceNotFoundException("Category", " category id", categoryid));
		return this.modelMapper.map(category, CategoryDto.class);
	}
	//getall
	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> list = this.categoryRepository.findAll();
		List<CategoryDto> listdto = list.stream().map((category)->this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
		return listdto;
	}
}
