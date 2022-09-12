package com.example.Microservicesuserservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Microservicesuserservice.VO.Department;
import com.example.Microservicesuserservice.VO.ResponseTemplateVO;
import com.example.Microservicesuserservice.entity.User;
import com.example.Microservicesuserservice.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public User saveUser(User user) {
		
		return userRepository.save(user);
	
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		
		log.info("Inside getUserWithDepartment in userservice");
		
		ResponseTemplateVO vo = new ResponseTemplateVO();
		
	User user = userRepository.findById(userId).get();
	
	Department deparment = restTemplate.getForObject("http://localhost:8082/departments/"+ user.getDepartmentId(), Department.class);
		
	vo.setUser(user);
	vo.setDepartment(deparment);
	
	
	return vo;
	}

}
