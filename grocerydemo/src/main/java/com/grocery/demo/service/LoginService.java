package com.grocery.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.demo.dao.LoginRepository;
import com.grocery.demo.model.Login;

@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepo;
public Login saveUser(Login u)
{
return loginRepo.save(u);
}
public String validateUser(String username,String password)
{
	String result="";
	Login u=loginRepo.findByUsername(username);
	if(u==null)
	{
		result="Invalid user";
	}
		else
		{
			if(u.getPassword().equals(password))
			{
				result="Login success";
			}
			else
			{
				result="Login failed";
			}
		}
	

	return result;
	}
	
	
	}
