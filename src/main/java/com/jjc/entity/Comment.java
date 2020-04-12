/**
 * 
 */
package com.jjc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.jjc.entity.base.AbstractEntity;

/**
 * @author jjc
 *
 */
@Table
@Entity
public class Comment extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String review;

	public Comment() {
		super();
	}

	public Comment(String review) {
		super();
		this.review = review;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
}
