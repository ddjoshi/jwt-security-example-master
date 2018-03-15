package com.techprimers.security.jwtsecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.techprimers.security.jwtsecurity.model.JwtUser;
import com.techprimers.security.jwtsecurity.repository.*;
@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
     protected UserRepository userRepository;
	
	
	@Override
	public String addUser(JwtUser user) {
		userRepository.save(user);			
		return "Saved";
	}
    @Override
	public JwtUser findJwtUserByUserName(String userName) {
		
		return userRepository.findJwtUserByUserName(userName);		 
	}

	


}
