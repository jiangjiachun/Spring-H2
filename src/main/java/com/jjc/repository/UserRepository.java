package com.jjc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jjc.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserDao {
	
	public User findByName(String name);
}
