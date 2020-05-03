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

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import com.jjc.entity.base.AbstractEntity;

/**
 * @author jjc
 *
 */
@Table
@Entity
public class Content extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String title;
	
	@OneToOne(mappedBy = "content", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	private ContentDetails details;

	public Content() {
		super();
	}

	public Content(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ContentDetails getDetails() {
		return details;
	}

	public void setDetails(ContentDetails details) {
		this.details = details;
	}
	
	public void addDetails(ContentDetails details) {
		details.setContent(this);
		this.details = details;
	}

	public void removeDetails() {
		if (details != null) {
			details.setContent(null);
			this.details = null;
		}
	}
}
