/**
 * 
 */
package com.jjc;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jjc.entity.Phone;
import com.jjc.entity.PhoneDetails;

/**
 * @author jjc 
 * 单向关联
 */
@Transactional
@SpringBootTest
public class OneToOneUnidirectionalTests {

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	public void test1() {
		PhoneDetails phoneDetails = new PhoneDetails("provider", "technology");
		Phone phone = new Phone("number", phoneDetails);
		entityManager.persist(phone);
		entityManager.clear();

		entityManager.find(PhoneDetails.class, 1);
	}

	
}
