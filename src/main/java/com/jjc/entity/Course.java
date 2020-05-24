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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jjc.entity.base.AbstractEntity;

/**
 * @author jjc
 *
 */
@Table
@Entity
public class Course extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String name;
	
	@ManyToMany(mappedBy = "courses", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private List<Teacher> teachers = new ArrayList<>();
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<StudentCourse> studentCourses = new ArrayList<>();
	
	public Course() {
		super();
	}

	public Course(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
		teacher.getCourses().add(this);
	}

	public void removeTeacher(Teacher teacher) {
		teachers.remove(teacher);
		teacher.getCourses().remove(this);
	}
	
	public List<StudentCourse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(List<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}

	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( o == null || getClass() != o.getClass() ) {
			return false;
		}
		Course course = (Course) o;
		return Objects.equals(getId(), course.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}
