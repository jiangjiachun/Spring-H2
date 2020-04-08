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
 *
 */
@Transactional
@SpringBootTest
public class OneToManyTests {

	@Resource
	private UserRepository userRepository;
	
	@Resource
	private UnitRepository unitRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	@Test
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
		unit.getUsers().add(user1);
		unit.getUsers().add(user2);
		
		unitRepository.save(unit);
		
		// orphanRemoval = true执行delete，默认：false
		unit.getUsers().remove(user1);
		unitRepository.flush();
	}
	
	@Test
	@Disabled
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
		unit.getUsers().add(user1);
		unit.getUsers().add(user2);
		
		em.persist(unit);
		
		// orphanRemoval = true执行delete，默认：false
		unit.getUsers().remove(user1);
		em.flush();
	}
}
