package com.example.Microservicesuserservice.service;

import com.example.Microservicesuserservice.VO.ResponseTemplateVO;
import com.example.Microservicesuserservice.entity.User;

public interface UserService {

	public User saveUser(User user);
	
	public ResponseTemplateVO getUserWithDepartment(Long userId);
		
	
	
}
