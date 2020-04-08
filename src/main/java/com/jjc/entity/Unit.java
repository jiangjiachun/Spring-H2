package com.jjc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jjc.entity.base.AbstractEntity;

@Entity
@Table
public class Unit extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String name;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDatetime;

	@JsonIgnore
	@OneToMany(mappedBy = "unit", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = User.class)
	private List<User> users = new ArrayList<>();

	public Unit() {
		super();
	}

	public Unit(String name, Date createDatetime) {
		super();
		this.name = name;
		this.createDatetime = createDatetime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
