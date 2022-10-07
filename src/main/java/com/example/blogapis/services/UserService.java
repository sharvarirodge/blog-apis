package com.example.blogapis.services;

import java.util.List;

import com.example.blogapis.payloads.UserDto;

public interface UserService {

//	createUser(User user)
	
//	public UserDto createUser(UserDto userDto) {
//		
//	}
	
	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto userDto,Integer userId);
	
	//UserDto deleteUser(UserDto userDto,Integer userId);
	UserDto getUserById(Integer userId);
	//UserDto getAllUsers
	
	List<UserDto> getAllUsers();
	//void deleteUser(UserDto userDto,Integer userId); wrong
	
	void deleteUser(Integer userId);
	
	
	
	
	
}
