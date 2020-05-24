/**
 * 
 */
package com.jjc.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author jjc
 *
 */
@Table
@Entity
public class StudentCourse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	private Student student;
	
	@Id
	@ManyToOne
	private Course course;

	public StudentCourse(Student student, Course course) {
		super();
		this.student = student;
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( o == null || getClass() != o.getClass() ) {
			return false;
		}
		StudentCourse that = (StudentCourse) o;
		return Objects.equals(student, that.getStudent()) &&
				Objects.equals(course, that.getCourse());
	}

	@Override
	public int hashCode() {
		return Objects.hash(student, course);
	}
}
