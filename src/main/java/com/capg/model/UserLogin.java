package com.capg.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class UserLogin {
	@Id
    private int id;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserLogin(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	
	public UserLogin() {}
	
	@Override
	public String toString() {
		return "UserLogin [id=" + id + ", password=" + password +"]";
	}
}