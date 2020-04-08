package com.jjc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.jjc.entity.base.AbstractEntity;

@Entity
@Table
public class User extends AbstractEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "email", nullable = false, length = 250)
	private String email;
	
	@NotNull
	@Range(max = 150, min = 1)
	@Column
	private Integer age;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDatetime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Unit unit;

	public User() {
	}

	public User(String name, String email, @NotNull @Range(max = 150, min = 1) Integer age, Date createDatetime,
			Unit unit) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.createDatetime = createDatetime;
		this.unit = unit;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
}
