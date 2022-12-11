package com.Bikkadit.service;

import java.util.List;

import com.Bikkadit.payload.PostDto;
import com.Bikkadit.payload.PostResponse;

public interface PostServicrI {

	//create 
	
	public PostDto createpost(PostDto postdto,Integer userId,Integer categoryId);
	
	//updatebyid
	public PostDto updatepost(PostDto postdto,int postId);
	//delete
	public void deletepostbyid(int postId);
	
	//getsinglepost
	public PostDto getBySingalPost(int postId);
	
	//getAll
	public PostResponse getAllpost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);;
	
	//get All npostsByCategory
	public List<PostDto> getAllPostsByCategory(int categoryId);
	
	//getAllPostsByUser
	public List<PostDto> getAllPostsByUser(int userId);
	
	//serch post
	public List<PostDto> serchPosts(String keywoed);
	
}
