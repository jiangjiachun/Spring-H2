package com.jjc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

import com.jjc.entity.UsersEntity;
import com.jjc.repository.UsersRepository;

/**
 * 
 * @author jjc
 *
 */
@Transactional
@SpringBootTest
public class UsersRepositoryTests {

	@Resource
	private UsersRepository usersRepository;
	
	//@Test
	public void countBySimpleExample() {
		Example<UsersEntity> example = Example.of(new UsersEntity(null, "张三", "", null));
		
		assertThat(usersRepository.count(example)).isEqualTo(1L);
	}
	
	//@Test
	public void ignoreProperties() {
		Optional<UsersEntity> users = usersRepository.findById(1L);
		Example<UsersEntity> example = Example.of(new UsersEntity(null, null, null, 32), 
				ExampleMatcher.matching().withIgnorePaths("id"));

		assertThat(usersRepository.findAll(example)).contains(users.get());
	}
	
	@Test
	public void likeMatching() {
		UsersEntity user = usersRepository.findByName("张三");
		Example<UsersEntity> example = Example.of(new UsersEntity(null, "张三", "com", null), 
				ExampleMatcher.matching().
//				withNullHandler(NullHandler.INCLUDE).
				withStringMatcher(StringMatcher.CONTAINING));

		assertThat(usersRepository.findAll(example)).contains(user);
	}

	//@Test
	public void usingLambdas() {
		Example<UsersEntity> example = Example.of(new UsersEntity(null, "张", "Com", null), 
				ExampleMatcher.matching().
				withIgnorePaths("id").
				withMatcher("name", matcher -> matcher.startsWith()).
				withMatcher("age", matcher -> matcher.transform(age -> Optional.of("23"))).
				withMatcher("email", matcher -> matcher.ignoreCase().contains()));

		assertThat(usersRepository.findAll(example));
	}
}
