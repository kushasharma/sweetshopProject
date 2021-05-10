package com.capg.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.model.Admin;
import com.capg.model.Sweet;
import com.capg.model.UserLogin;
import com.capg.repository.IAdminRepository;
import com.capg.repository.ISweetRepo;

@Service
public class AdminServiceImpl {
	@Autowired
	private IAdminRepository adminRepo;
	
	@Autowired
	private ISweetRepo sweetRepo;
	
	@Autowired
	private LoginServiceImpl loginService;
	public void addAdmin(Admin admin) {
		adminRepo.save(admin);
		loginService.addUser(new UserLogin(admin.getId(), admin.getPassword()));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public boolean validateUser(UserLogin user) {
		if(user.equals(loginService.getUserById(user.getId())))
			return true;
		return false;
	}
	
	public void addSweet(Sweet s) {
		sweetRepo.save(s);
	}

	public void updateSweet(Sweet s) {
		sweetRepo.save(s);
	}

	public void deleteSweet(int id) {
		sweetRepo.deleteById(id);
	}
	
	public Sweet getSweetById(int id) {
		return sweetRepo.findBySid(id);
	}
	
	public List<Sweet> getAllSweets() {
		return (List<Sweet>) sweetRepo.findAll();
	}
}