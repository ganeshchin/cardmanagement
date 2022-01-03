package com.cardmanagementsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardmanagementsystem.config.Response;
import com.cardmanagementsystem.model.Userdetalis;
import com.cardmanagementsystem.service.UserService;

@RestController
@RequestMapping
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public Response saveUser(@RequestBody @Valid Userdetalis userdetails) {

		return userService.createUser(userdetails);

	}
	
}