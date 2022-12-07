package org.pizzahat.com.demo.serv;

import java.util.List;

import org.hibernate.Hibernate;
import org.pizzahat.com.demo.pojo.Book;
import org.pizzahat.com.demo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;
	
	public void save(Book book) {
		
		bookRepo.save(book);
	}
	public void delete(Book book) {
		
		bookRepo.delete(book);
	}
	public List<Book> findAll() {
		
		return bookRepo.findAll();
	}
	@Transactional
	public Book findById(int id) {
	
		Book book = bookRepo.findById(id).get(); 
		
		Hibernate.initialize(book.getTags());;
		
		return book;
	}
}
