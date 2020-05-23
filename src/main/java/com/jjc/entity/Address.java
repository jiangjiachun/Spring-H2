/**
 * 
 */
package com.jjc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jjc.entity.base.AbstractEntity;

/**
 * @author jjc
 *
 */
@Entity
@Table
public class Address extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column
	private String number;
	
	@Column
	private String street;

	public Address() {
		super();
	}

	public Address(String number, String street) {
		super();
		this.number = number;
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
}
