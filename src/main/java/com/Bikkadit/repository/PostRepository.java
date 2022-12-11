package com.Bikkadit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bikkadit.entities.Category;
import com.Bikkadit.entities.Post;
import com.Bikkadit.entities.User;
@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
	
	public List<Post> findByUser(User user);
	public List<Post> findByCategory(Category category);
	
	public List<Post> findByTitleContaining(String Title);
}
