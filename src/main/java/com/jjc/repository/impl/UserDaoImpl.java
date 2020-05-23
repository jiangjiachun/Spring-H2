package com.jjc.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jjc.entity.User;
import com.jjc.repository.UserDao;

public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
    private EntityManager em;
	
	@Override
	public User findName() {
		List<User> result = em.createQuery("from User", User.class ).getResultList();
		result.forEach(action -> System.out.println( "User (" + action.getName() + ") : " + action.getEmail()));
		return null;
	}

	@Override
	public List<User> list(Integer unitId) {
		List<User> users = em.createQuery("select u from User u where u.unit.id = :unitId", User.class)
			.setParameter("unitId", unitId).getResultList();
		
		return users;
	}

}
