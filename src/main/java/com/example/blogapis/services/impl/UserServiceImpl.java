package com.example.blogapis.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogapis.entities.User;
import com.example.blogapis.exceptions.ResourceNotFoundException;
import com.example.blogapis.payloads.UserDto;
import com.example.blogapis.repositories.UserRepository;
import com.example.blogapis.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	// now to implement interface, we need userRepo

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
//		Now, to create User, we need user
//		But we have userDto
//		so we need to convert userDto-->User
//		1.use model mapper for the same
//		2.explicitly write 2 functions

		// getting in form of dto. assign it to user
		User user = this.dtoToUser(userDto);
		// saving functional
		// this.userRepository.save(user);
		User savedUser = this.userRepository.save(user);
		return this.userToDto(savedUser);

//		
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id ", userId));
//		User updatedUser = this.userRepository.save(userDetails);

		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());

		User updatedUser = this.userRepository.save(user);
		return this.userToDto(updatedUser);

	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id ", userId));

		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> users = this.userRepository.findAll();

		// now convert all users into userdto

		List<UserDto> usersDto = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return usersDto;
	}

	@Override
	public void deleteUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		
		User deletedUser =this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		
		this.userRepository.delete(deletedUser);
		 
		

	}

	public User dtoToUser(UserDto userDto) {

		// 1.create user object
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		return user;
	}

	public UserDto userToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setAbout(user.getAbout());
		userDto.setEmail(user.getEmail());
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setPassword(user.getPassword());
		return userDto;

	}

}
