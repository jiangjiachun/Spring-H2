/**
 * 
 */
package com.jjc;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jjc.entity.Address;
import com.jjc.entity.User;

/**
 * @author jjc
 * 单向关联
 */
@Transactional
@SpringBootTest
public class ManyToManyUnidirectionalTests {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Order(1)
	@Test
	public void test1() {
		User user1 = new User("user1", "user1@163.com", 22, null);
		
		User user2 = new User("user2", "user2@163.com", 32, null);
		
		Address address1 = new Address("number1", "street1");
		Address address2 = new Address("number2", "street2");
		
		user1.getAddresses().add(address1);
		user1.getAddresses().add(address2);
		
		user2.getAddresses().add(address1);
		
		entityManager.persist(user1);
		entityManager.persist(user2);
		
		entityManager.flush();
		
		user1.getAddresses().remove(address1);
		
		entityManager.flush();
	}
	
	@Order(2)
	@Test
	public void test2() {
		User user = entityManager.find(User.class, 1);
		entityManager.remove(user);
		entityManager.flush();
		
	}
}
