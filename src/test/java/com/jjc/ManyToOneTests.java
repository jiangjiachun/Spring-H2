/**
 * 
 */
package com.jjc;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jjc.entity.Unit;
import com.jjc.entity.User;

/**
 * @author jjc
 *
 */
@Transactional
@SpringBootTest
public class ManyToOneTests {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Test
	public void test() {
		Unit unit = new Unit("unit1", new Date());
		
		entityManager.persist(unit);
		
		User user = new User("user1", "user1@gmail.com", 20, unit);
		
		entityManager.persist(user);
		System.out.println(user.getCreateDatetime());
		
		user.setUnit(null);
		
		entityManager.flush();
	}
}
