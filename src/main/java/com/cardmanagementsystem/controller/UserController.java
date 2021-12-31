package com.cardmanagementsystem.controller;

import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardmanagementsystem.config.Responses;
import com.cardmanagementsystem.dao.UserDao;
import com.cardmanagementsystem.model.Userdetalis;
import com.cardmanagementsystem.model.Userdetalis.KYCStatus;
import com.cardmanagementsystem.model.Userdetalis.Title;
import com.cardmanagementsystem.service.UserService;
import com.cardmanagementsystem.userinfo.User;

@RestController
@RequestMapping
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public Responses saveUser(@RequestBody @Valid User user) {

		return userService.saveUser(user);

	}

}