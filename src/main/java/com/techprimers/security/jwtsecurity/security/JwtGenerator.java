package com.techprimers.security.jwtsecurity.security;

import com.techprimers.security.jwtsecurity.service.UserService;
import com.techprimers.security.jwtsecurity.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {

	@Autowired 
	private UserService userService;
	Claims claims;
    public String generate(JwtUser jwtUser) {
    	

    	JwtUser tempUser = userService.findJwtUserByUserName(jwtUser.getUserName());
    	
    	System.out.print(jwtUser.getPassword()+jwtUser.getUserName());
    	
    	if(tempUser.getPassword().equals(jwtUser.getPassword()) && tempUser.getUserName().equals(jwtUser.getUserName()))
    	{
    	
        claims = Jwts.claims()
                .setSubject(jwtUser.getUserName());
        claims.put("password", String.valueOf(jwtUser.getPassword()));
        claims.put("role", jwtUser.getRole());


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512,"youtube")
                .compact();
    	}
    	else
    	{
            return "Login Failed";
    	}
    }
}
