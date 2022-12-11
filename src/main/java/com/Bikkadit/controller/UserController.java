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

import com.Bikkadit.exceptions.ResourceNotFoundException;
import com.Bikkadit.payload.ApiResponce;
import com.Bikkadit.payload.UserDto;
import com.Bikkadit.service.UserServiceI;



@RestController
public class UserController {
	
	@Autowired
	private UserServiceI userServiceI;
	
	//1.created postmapping update both
	/**
	 * @author Balasaheb
	 * @apiNote this api for create User
	 * @exception ResourceNotFoundException
	 * @param userdto
	 * @return
	 */
	@PostMapping(value ="/usercreated")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userdto){
		UserDto createUser = userServiceI.createUser(userdto);
		return new ResponseEntity<UserDto>(createUser,HttpStatus.CREATED);
	}

	//2.Upadate putmapping
	@PutMapping(value ="/updateUSer/{id}" )
	public ResponseEntity<UserDto> updateUser( @Valid @RequestBody UserDto userdto,@PathVariable int id){
		UserDto userDto2 = userServiceI.updateUser(userdto, id);
		
		return new ResponseEntity<UserDto>(userDto2,HttpStatus.OK);
		
	}
	//3.Delete user DeleteMapping
	@DeleteMapping(value ="/deleteById/{id}")
	public ResponseEntity<ApiResponce> deletebyid(@Valid @PathVariable int id){
		  userServiceI.deleteUser(id);
	    return new ResponseEntity<ApiResponce>(new ApiResponce("user deleted Successfully",true),HttpStatus.OK);
	}
	
	//4.getuserbyId getmapping
	
	@GetMapping(value ="/getuserbyid/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable int id){
		UserDto userById = userServiceI.getUserById(id);
		
		return new ResponseEntity<UserDto>(userById,HttpStatus.OK);
	} 
	
	//5.getallUsers 
	@GetMapping(value ="/getAllusers")
	public ResponseEntity<List<UserDto>> getAllUser(){
		List<UserDto> allUsers = userServiceI.getAllUsers();
		return new ResponseEntity<List<UserDto>>(allUsers,HttpStatus.OK);
	}
}
