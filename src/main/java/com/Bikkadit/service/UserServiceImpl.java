package com.Bikkadit.service;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bikkadit.entities.User;
import com.Bikkadit.exceptions.ResourceNotFoundException;
import com.Bikkadit.payload.UserDto;
import com.Bikkadit.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServiceI {
 
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	//1.creteSave
	@Override//save mathods
	public UserDto createUser(UserDto userdto) {
	 User user = this.modelMapper.map(userdto, User.class);
	 User save = this.userRepository.save(user);
		return this.modelMapper.map(save, UserDto.class);
	}
	
	//2.Update
	@Override
	public UserDto updateUser(UserDto userdto, Integer userId) {
		User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		
		
		user.setName(userdto.getName());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getAbout());
		user.setAbout(userdto.getAbout());
		
		User user2 = this.userRepository.save(user);
		return this.modelMapper.map(user2, UserDto.class);
		
	}
   
	//3.GetUserById
	@Override
	public UserDto getUserById(Integer userId) {
		  User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id",userId));
		  
		  return this.modelMapper.map(user, UserDto.class);

	}

	//4.GetAllUsers
	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepository.findAll();
		List<UserDto> userdtos=users.stream().map(user ->this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		
		return userdtos;
	}

	//5.Deleteoprations
	@Override
	public void deleteUser(int userId) {
		 User user = this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id", userId));
		this.userRepository.delete(user);
		
	}
//	//convert dto-->User
	public User dtoToUser(UserDto userdto) {
		User user = this.modelMapper.map(userdto, User.class);
	return user;
		
	}  
//	
//	//converter user to--->DTO
	public UserDto userToDto(User user) {
		UserDto ut = this.modelMapper.map(user, UserDto.class);
			return ut;
		
	}}


