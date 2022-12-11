package com.Bikkadit.service;

import java.util.List;

import com.Bikkadit.payload.UserDto;

public interface UserServiceI {
	
	public UserDto createUser(UserDto userdto);//save
	
	public UserDto updateUser(UserDto userdto , Integer userId);//update
	
	public UserDto getUserById(Integer userId);//get
	
	public List<UserDto> getAllUsers();//getall
	
	public void deleteUser(int userId);//delete

}
