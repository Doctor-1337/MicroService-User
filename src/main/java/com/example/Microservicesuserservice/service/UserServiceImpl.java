package com.example.Microservicesuserservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Microservicesuserservice.entity.User;
import com.example.Microservicesuserservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user) {
		
		return userRepository.save(user);
	
	}

}
