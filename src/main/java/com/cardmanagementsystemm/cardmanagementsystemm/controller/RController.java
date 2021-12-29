package com.cardmanagementsystemm.cardmanagementsystemm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cardmanagementsystemm.cardmanagementsystemm.controller.dao.UserDao;
import com.cardmanagementsystemm.cardmanagementsystemm.model.Userdetalis;


	@RestController
	public class RController {
		@Autowired
		private UserDao userdao;
		
		@PostMapping("/user")  
		public String saveUser(@RequestBody Userdetalis userdetails)   
		{  
			
		return userdao.savePerson(userdetails);
		}  

		@GetMapping("/user1")  
		public String saveUser()   
		{  
			
			Userdetalis usr= new Userdetalis();
			usr.setName("suresh");
			usr.setPan("AYBPC8351R");
			usr.setPhonenumber(78899);
			
		return userdao.savePerson(usr);
		}  
}