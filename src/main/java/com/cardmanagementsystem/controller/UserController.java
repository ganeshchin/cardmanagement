package com.cardmanagementsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardmanagementsystem.config.Response;
import com.cardmanagementsystem.model.UserDetalis;
import com.cardmanagementsystem.service.UserService;

@RestController
@RequestMapping
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public Response saveUser(@RequestBody @Valid UserDetalis userDetails) {

		return userService.createUser(userDetails);

	}
	@GetMapping("/api/userdetails/{id}")
	public Response getUserAndAddressDetailsById(@PathVariable int id) {
		return userService.getUserAndAddressDetailsById(id);
		
	}
	
	
	
}