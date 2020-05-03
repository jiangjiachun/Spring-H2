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
public class PhoneDetails extends AbstractEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String provider;

	@Column
	private String technology;

	public PhoneDetails() {
		super();
	}

	public PhoneDetails(String provider, String technology) {
		super();
		this.provider = provider;
		this.technology = technology;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}
	
}
