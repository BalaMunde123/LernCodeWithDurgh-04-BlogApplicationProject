package com.Bikkadit.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Bikkadit.entities.Category;
import com.Bikkadit.entities.Post;
import com.Bikkadit.entities.User;
import com.Bikkadit.exceptions.ResourceNotFoundException;
import com.Bikkadit.payload.PostDto;
import com.Bikkadit.payload.PostResponse;
import com.Bikkadit.repository.CategoryRepository;
import com.Bikkadit.repository.PostRepository;
import com.Bikkadit.repository.UserRepository;
@Service
public class PostServiceImpl implements PostServicrI {
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public PostDto createpost(PostDto postdto,Integer userId,Integer categoryId) {
		
		 User user = this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id", userId));
		Category category = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Id", categoryId));
	
		Post post = this.modelMapper.map(postdto, Post.class);
		post.setImageName("Defalut.png");
		post.setAddedDate(new Date());
		post.setCategory(category);
		post.setUser(user);
		
		Post post2 = this.postRepository.save(post);
		return this.modelMapper.map(post2, PostDto.class);
	}
//update post
	@Override
	public PostDto updatepost(PostDto postdto, int postId) {
		Post post = this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "post Id", postId));
		post.setTitle(postdto.getTitle());
		post.setImageName(postdto.getImageName());
		post.setContent(postdto.getContent());
		Post newpost = this.postRepository.save(post);
		return this.modelMapper.map(newpost, PostDto.class);
	} 
//delete
	@Override
	public void deletepostbyid(int postId) {
		Post post = this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "post Id", postId));
		this.postRepository.delete(post);
	}
//singlepost
	@Override
	public PostDto getBySingalPost(int postId) {
		Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "post id", postId));
		
		return this.modelMapper.map(post, PostDto.class);
	}
//get All posts
	@Override
	public PostResponse getAllpost( Integer pageNumber,Integer pageSize,String sortBy,String sortDir) {
	Sort sort=(sortDir.equalsIgnoreCase("asc"))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
	
		PageRequest p = PageRequest.of(pageNumber, pageSize,sort);
	 Page<Post> pagepost = this.postRepository.findAll(p);
	 List<Post> posts = pagepost.getContent();
		List<PostDto> postdtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        PostResponse postResponse=new PostResponse();
        postResponse.setContent(postdtos);
        postResponse.setPagesize(pagepost.getSize());
        postResponse.setPageno(pagepost.getNumber());
        postResponse.setTotalElement(pagepost.getTotalElements());
        postResponse.setTotalpages(pagepost.getTotalPages());
        postResponse.setLastpage(pagepost.isLast());
		return postResponse;
	}

	@Override
	public List<PostDto> getAllPostsByCategory(int categoryId) {
		Category cat = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "category Id", categoryId));
		List<Post> posts= this.postRepository.findByCategory(cat);
		List<PostDto> collect = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<PostDto> getAllPostsByUser(int userId) {
		User user = this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user Id", userId));
		List<Post> posts = this.postRepository.findByUser(user);
	List<PostDto> postdtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postdtos;
	}

	@Override
	public List<PostDto> serchPosts(String keywoed) {
		// TODO Auto-generated method stub
		return null;
	}

}
