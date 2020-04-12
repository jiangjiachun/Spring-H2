package com.jjc.repository;

import java.util.List;

import com.jjc.entity.User;

public interface UserDao {

	public User findName();
	
	public List<User> list(Integer unitId);
}
