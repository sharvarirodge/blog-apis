package com.example.blogapis.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogapis.payloads.ApiResponse;
import com.example.blogapis.payloads.UserDto;
import com.example.blogapis.services.UserService;

@RestController
@RequestMapping("/api/users")

public class UserController {

	// diff methods to handle diff re
	// post
	// put
	// delete
	// get

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
//		List<UserDto> getAllUsers =  this.userService.getAllUsers();
//		return new ResponseEntity<>(getAllUsers,HttpStatus.ACCEPTED);
		
		return ResponseEntity.ok(this.userService.getAllUsers());
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable Integer userId){
		
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	

	@PostMapping("/")
	public ResponseEntity<UserDto> createuser(@Valid @RequestBody UserDto userDto) {
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	
	//path uri variable.
	//this is fetched in @Path variable
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId){
		UserDto updatedUser = this.userService.updateUser(userDto, userId);
		//return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
		
		//UserDto deletedUser = this.userService.deleteUser(userId);
		this.userService.deleteUser(userId);
	//	return new ResponseEntity<>(deletedUser, HttpStatus.OK);
		//return new ResponseEntity(Map.of("message","User Deleted Successfully"),HttpStatus.OK);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
	
	}
	
	
}
