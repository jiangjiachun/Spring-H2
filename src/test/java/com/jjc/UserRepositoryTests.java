package com.jjc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

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
public class UserRepositoryTests {

	@Resource
	private UserRepository userRepository;
	
	@Resource
	private UnitRepository unitRepository;
	
	//@Test
	public void countBySimpleExample() {
		Example<User> example = Example.of(new User("张三", null, null, null, null));
		
		assertThat(userRepository.count(example)).isEqualTo(1L);
	}
	
	//@Test
	public void ignoreProperties() {
		Optional<User> users = userRepository.findById(1);
		Example<User> example = Example.of(new User("张三", null, null, null, null), 
				ExampleMatcher.matching().withIgnorePaths("id"));

		assertThat(userRepository.findAll(example)).contains(users.get());
	}
	
//	@Test
	public void likeMatching() {
		unitRepository.save(new Unit("游戏公司", new Date()));
		unitRepository.findAll().forEach(action -> System.out.println(action.getName()));
		userRepository.findName();
		User user = userRepository.findByName("张三");
		Example<User> example = Example.of(new User("张三", null, null, null, null), 
				ExampleMatcher.matching().
//				withNullHandler(NullHandler.INCLUDE).
				withStringMatcher(StringMatcher.CONTAINING));

		assertThat(userRepository.findAll(example)).contains(user);
	}

	//@Test
	public void usingLambdas() {
		Example<User> example = Example.of(new User("张三", null, null, null, null), 
				ExampleMatcher.matching().
				withIgnorePaths("id").
				withMatcher("name", matcher -> matcher.startsWith()).
				withMatcher("age", matcher -> matcher.transform(age -> Optional.of("23"))).
				withMatcher("email", matcher -> matcher.ignoreCase().contains()));

		assertThat(userRepository.findAll(example));
	}
	
	@Test
	public void list() {
		userRepository.list(1);
	}
}
