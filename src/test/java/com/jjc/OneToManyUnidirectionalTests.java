/**
 * 
 */
package com.jjc;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jjc.entity.Comment;
import com.jjc.entity.Post;
import com.jjc.entity.School;
import com.jjc.entity.Teacher;

/**
 * @author jjc
 * 单向关联
 */
@Transactional
@SpringBootTest
public class OneToManyUnidirectionalTests {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Test
	public void test1() {
		Teacher teacher1 = new Teacher("teacher1");
		Teacher teacher2 = new Teacher("teacher2");
		
		School school = new School("school1");
		school.getTeacher().add(teacher1);
		school.getTeacher().add(teacher2);
		
		entityManager.persist(school);
		entityManager.flush();
	}
	
	@Test
	public void test2() {
		Comment comment1 = new Comment("comment1");
		Comment comment2 = new Comment("comment2");
		
		Post post = new Post("post1");
		post.getComments().add(comment1);
		post.getComments().add(comment2);
		
		entityManager.persist(post);
		entityManager.flush();
		
	}
}
