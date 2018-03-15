package com.techprimers.security.jwtsecurity.service;

import java.util.List;


import com.techprimers.security.jwtsecurity.model.JwtUser;

public interface UserService {

	String addUser(JwtUser user);
	
	JwtUser findJwtUserByUserName(String userName);
	
	
}
