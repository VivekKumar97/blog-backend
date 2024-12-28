package com.bloggingbackend.blog_api.controllers;
import com.bloggingbackend.blog_api.exception.BlogException;
import com.bloggingbackend.blog_api.payloads.ApiResponse;
import org.springframework.web.bind.annotation.*;

import com.bloggingbackend.blog_api.payloads.UserDto;
import com.bloggingbackend.blog_api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
//import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto usrdto){
		UserDto userdto1= this.userservice.createUser(usrdto);
		return new ResponseEntity<>(userdto1, HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer id) throws BlogException {
		UserDto userdto1= this.userservice.updateUser(userDto, id);
//		UserDto updateduser= this.userservice.updateUser(userDto,id);
		return ResponseEntity.ok(userdto1);
	}
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable Integer id) throws BlogException{
		UserDto userdto1= this.userservice.getUser(id);
		return ResponseEntity.ok(userdto1);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id){
		this.userservice.deleteUser(id);
		return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> ls= this.userservice.getAllUsers();
		return ResponseEntity.ok(ls);
	}
}
