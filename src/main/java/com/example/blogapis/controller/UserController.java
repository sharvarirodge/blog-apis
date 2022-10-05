package com.example.blogapis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<List<UserDto>> getAllUsers(@RequestBody UserDto userDto)
	{
		List<UserDto> getAllUsers =  this.userService.getAllUsers();
		return new ResponseEntity<>(getAllUsers,HttpStatus.ACCEPTED);
		
	}
	


	@PostMapping("/")
	public ResponseEntity<UserDto> createuser(@RequestBody UserDto userDto) {
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	
	
}
