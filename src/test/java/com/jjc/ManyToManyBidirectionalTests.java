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

import com.jjc.entity.Course;
import com.jjc.entity.Student;
import com.jjc.entity.Teacher;

/**
 * @author jjc
 * 双向关联
 */
@Transactional
@SpringBootTest
public class ManyToManyBidirectionalTests {

	@PersistenceContext
	private EntityManager entityManager;
	
	/*
	 * @Order(1)
	 * 
	 * @Test
	 */
	public void test1() {
		Teacher teacher1 = new Teacher("teacher1");
		Teacher teacher2 = new Teacher( "teacher2");

		Course course1 = new Course("course1");
		Course course2 = new Course("course2");
		
		teacher1.addCourse(course1);
		teacher1.addCourse(course2);
		
		teacher2.addCourse(course2);
		

		entityManager.persist(teacher1);
		entityManager.persist(teacher2);

		entityManager.flush();

		teacher1.removeCourse(course1);
		
		entityManager.flush();
	}
	
	/*
	 * @Order(2)
	 * 
	 * @Test
	 */
	public void test2() {
		Teacher teacher1 = new Teacher("teacher1");
		Teacher teacher2 = new Teacher( "teacher2");

		Course course1 = new Course("course1");
		Course course2 = new Course("course2");
		
		course1.addTeacher(teacher1);
		course1.addTeacher(teacher2);
		
		course2.addTeacher(teacher2);
		

		entityManager.persist(course1);
		entityManager.persist(course2);

		entityManager.flush();

		course1.removeTeacher(teacher1);
		
		entityManager.flush();
	}
	
	@Order(3)
	@Test
	public void test3() {
		Student student1 = new Student("student1");
		Student student2 = new Student("student2");

		Course course1 = new Course("course1");
		Course course2 = new Course("course2");

		entityManager.persist(student1);
		entityManager.persist(student2);

		entityManager.persist(course1);
		entityManager.persist(course2);

		student1.addCourse(course1);
		student1.addCourse(course2);

		student2.addCourse(course1);

		entityManager.flush();

		student1.removeCourse(course1);
		
		entityManager.flush();
	}
}
