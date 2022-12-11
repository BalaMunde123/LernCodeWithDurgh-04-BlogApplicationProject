package com.Bikkadit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Bikkadit.payload.ApiResponce;
import com.Bikkadit.payload.PostDto;
import com.Bikkadit.payload.PostResponse;
import com.Bikkadit.service.PostServicrI;

@RestController
public class PostController {
	@Autowired
	private PostServicrI postServicrI;
	//create
	@PostMapping("/createPost/userId/{userId}/categoryid/{categoryId}")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postdto,@PathVariable Integer userId,@PathVariable Integer categoryId){
		PostDto postDto2 = this.postServicrI.createpost(postdto, userId, categoryId);
		return new ResponseEntity<PostDto>(postDto2,HttpStatus.CREATED) ;
		
		
	}
	
	//get posts ByUser
	@GetMapping("/getUserpost/{userId}/posts")
	public ResponseEntity<List<PostDto>> getpostsByUser(@PathVariable Integer userId){
		List<PostDto> allPostsByUser = this.postServicrI.getAllPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(allPostsByUser,HttpStatus.OK);
	}
  //get posts By Category
	@GetMapping("/getCategorypost/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
		List<PostDto> list = this.postServicrI.getAllPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(list,HttpStatus.OK);

	}
	//get All posts
	@GetMapping("/getAllPosts")
	public ResponseEntity<PostResponse> getAllPOsts(@RequestParam(value ="pageNumber",defaultValue ="1",required = false) Integer pageNumber,
		                                             @RequestParam(value ="pageSize", defaultValue ="5",required =false) Integer pageSize,
		                                             @RequestParam (value ="sortBy",defaultValue ="postId",required =false) String sortBy,
		                                             @RequestParam(value ="sortDir",defaultValue ="ASC",required =false) String sortDir){
		PostResponse postResponse = this.postServicrI.getAllpost(pageNumber,pageSize,sortBy,sortDir);
		return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);
	}
	//get singale post
	@GetMapping("/getSinglepost/{postId}")
	public ResponseEntity<PostDto> getSinglePost(@PathVariable Integer postId){
		PostDto postdto = this.postServicrI.getBySingalPost(postId);
		return new ResponseEntity<PostDto>(postdto,HttpStatus.OK);
	}
	
	//delete post id
    @DeleteMapping("/postById/{postId}")
	public ApiResponce deletepostbyId(@PathVariable Integer postId){
		this.postServicrI.deletepostbyid(postId);
		return  new ApiResponce("Post deleted successfully!!!!", true);
		
	}
    //update post
    @PutMapping("/updatepostbyId/{postId}")
    public ResponseEntity<PostDto> updatepostById(@RequestBody PostDto postdto,@PathVariable Integer postId){
    	PostDto updatepost = this.postServicrI.updatepost(postdto, postId);
    	return new ResponseEntity<PostDto>(updatepost,HttpStatus.OK);
    }
	
	
}
