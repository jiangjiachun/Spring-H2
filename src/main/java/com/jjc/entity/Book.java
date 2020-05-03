/**
 * 
 */
package com.jjc.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jjc.entity.base.AbstractEntity;

/**
 * @author jjc
 *
 */
@Entity
@Table
public class Book extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "book", orphanRemoval = true, fetch = FetchType.LAZY)
	private BookDetails details;

	public Book() {
		super();
	}

	public Book(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BookDetails getDetails() {
		return details;
	}

	public void setDetails(BookDetails details) {
		this.details = details;
	}
	
	public void addDetails(BookDetails details) {
		details.setBook(this);
		this.details = details;
	}

	public void removeDetails() {
		if (details != null) {
			details.setBook(null);
			this.details = null;
		}
	}
}
