package com.example.Microservicesuserservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Microservicesuserservice.VO.ResponseTemplateVO;
import com.example.Microservicesuserservice.entity.User;
import com.example.Microservicesuserservice.service.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		 
		log.info("Inside controller save user method");
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
		
		log.info("Inside getuserwithdept method in user controller");
		return userService.getUserWithDepartment(userId);
	}
}
