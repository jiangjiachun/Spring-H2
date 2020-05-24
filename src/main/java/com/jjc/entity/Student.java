/**
 * 
 */
package com.jjc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jjc.entity.base.AbstractEntity;

/**
 * @author jjc
 *
 */
@Table
@Entity
public class Student extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<StudentCourse> studentCourses = new ArrayList<>();

	public Student() {
		super();
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StudentCourse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(List<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}
	
	public void addCourse(Course course) {
		StudentCourse studentCourse = new StudentCourse(this, course);
		studentCourses.add(studentCourse);
		course.getStudentCourses().add(studentCourse);
	}

	public void removeCourse(Course course) {
		StudentCourse studentCourse = new StudentCourse(this, course);
		course.getStudentCourses().remove(studentCourse);
		studentCourses.remove(studentCourse);
		studentCourse.setCourse(null);
		studentCourse.setStudent(null);
	}

	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( o == null || getClass() != o.getClass() ) {
			return false;
		}
		Student student = (Student) o;
		return Objects.equals(getId(), student.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}
