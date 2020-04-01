package com.jjc.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jjc.entity.User;
import com.jjc.repository.UsersDao;

public class UsersDaoImpl implements UsersDao {
	
	@PersistenceContext
    private EntityManager em;
	
	@Override
	public User findName() {
		// TODO Auto-generated method stub
		List<User> result = em.createQuery( "from User", User.class ).getResultList();
		result.forEach(action -> System.out.println( "User (" + action.getName() + ") : " + action.getEmail()));
		return null;
	}

}
