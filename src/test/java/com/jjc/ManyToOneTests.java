/**
 * 
 */
package com.jjc;

import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jjc.entity.Unit;
import com.jjc.entity.User;
import com.jjc.repository.UnitRepository;
import com.jjc.repository.UserRepository;

/**
 * 
 * @author jjc
 *
 */
@Transactional
@SpringBootTest
public class ManyToOneTests {

	@Resource
	private UserRepository userRepository;
	
	@Resource
	private UnitRepository unitRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	@Test
	public void test1( ) {
		Unit unit = unitRepository.save(new Unit("游戏公司", new Date()));
		
		User user = new User();
		user.setAge(20);
		user.setCreateDatetime(new Date());
		user.setEmail("test51@163.com");
		user.setName("test51");
		user.setUnit(unit);
		userRepository.save(user);
		
		user.setUnit(null);
		userRepository.saveAndFlush(user);
	}
	
	@Test
	public void test2() {
		Unit unit = new Unit("游戏公司", new Date());
		em.persist(unit);
		
		User user = new User();
		user.setAge(20);
		user.setCreateDatetime(new Date());
		user.setEmail("test51@163.com");
		user.setName("test51");
		user.setUnit(unit);
		em.persist(user); 
		
		user.setUnit(null);
		em.flush();
	}
}
