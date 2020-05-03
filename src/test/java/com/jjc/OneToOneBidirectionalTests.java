/**
 * 
 */
package com.jjc;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jjc.entity.Book;
import com.jjc.entity.BookDetails;
import com.jjc.entity.Content;
import com.jjc.entity.ContentDetails;

/**
 * @author jjc
 * 双向关联
 */
@Transactional
@SpringBootTest
public class OneToOneBidirectionalTests {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Test
	public void test() {
		Book book = new Book("name");
		BookDetails bookDetails = new BookDetails("author", "press");
		book.addDetails(bookDetails);
		entityManager.persist(book);
		entityManager.clear();
		
		entityManager.find(Book.class, 1);
	}
	
	@Test
	public void test2() {

		Content content = new Content();
		content.setTitle("title");
		ContentDetails details = new ContentDetails("text");
		content.addDetails(details);
		entityManager.persist(content);
		entityManager.clear();
		
		entityManager.find(Content.class, 1);

	}
}

