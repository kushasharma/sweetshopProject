package com.capg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.model.UserLogin;
import com.capg.repository.ILoginRepository;
@Service
public class LoginServiceImpl {
	@Autowired
	private ILoginRepository loginRepo;
	
	public void addUser(UserLogin user) {
		loginRepo.save(user);
	}
	
	public UserLogin getUserById(int id) {
		return loginRepo.findById(id);
	}
}
