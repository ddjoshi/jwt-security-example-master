package com.techprimers.security.jwtsecurity.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.techprimers.security.jwtsecurity.model.JwtUser;


public interface UserRepository extends JpaRepository<JwtUser, Long> {
	
	public JwtUser findJwtUserByUserName(String userName);

}
