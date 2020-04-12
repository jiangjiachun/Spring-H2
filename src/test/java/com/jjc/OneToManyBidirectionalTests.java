/**
 * 
 */
package com.jjc;

import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jjc.entity.Unit;
import com.jjc.entity.User;
import com.jjc.repository.UnitRepository;
import com.jjc.repository.UserRepository;

/**
 * @author jjc
 * 双向关联
 */
@Transactional
@SpringBootTest
public class OneToManyBidirectionalTests {

	@Resource
	private UserRepository userRepository;
	
	@Resource
	private UnitRepository unitRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Test
	@Disabled
	public void test1() {
		User user1 = new User();
		user1.setAge(21);
		user1.setCreateDatetime(new Date());
		user1.setEmail("test51@163.com");
		user1.setName("test51");
		
		User user2 = new User();
		user2.setAge(22);
		user2.setCreateDatetime(new Date());
		user2.setEmail("test52@163.com");
		user2.setName("test52");
		
		Unit unit = new Unit("游戏公司", new Date());
		unit.addUser(user1);
		unit.addUser(user2);
		
		unitRepository.save(unit);
		
		// orphanRemoval = true执行delete，默认：false
		unit.removeUser(user2);
		unitRepository.flush();
	}
	
	@Test
	public void test2() {
		User user1 = new User();
		user1.setAge(21);
		user1.setCreateDatetime(new Date());
		user1.setEmail("test51@163.com");
		user1.setName("test51");
		
		User user2 = new User();
		user2.setAge(22);
		user2.setCreateDatetime(new Date());
		user2.setEmail("test52@163.com");
		user2.setName("test52");
		
		Unit unit = new Unit("游戏公司", new Date());
		unit.addUser(user1);
		unit.addUser(user2);
		
		entityManager.persist(unit);
		
		// orphanRemoval = true执行delete，默认：false
		unit.removeUser(user1);
		entityManager.flush();
	}
}
