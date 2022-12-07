package org.pizzahat.com.demo;

import java.util.Arrays;

import org.pizzahat.com.demo.pojo.Book;
import org.pizzahat.com.demo.pojo.Tag;
import org.pizzahat.com.demo.serv.BookService;
import org.pizzahat.com.demo.serv.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRelTestApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private TagService tagService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRelTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Book b1 = new Book("b1");
		Book b2 = new Book("b2");
		Book b3 = new Book("b3");
		Book b4 = new Book("b4");
		
		Arrays.asList(new Book[] {b1, b2, b3, b4}).forEach(bookService::save);
		
		Tag t1 = new Tag("t1");
		Tag t2 = new Tag("t2");
		Tag t3 = new Tag("t3");
		Tag t4 = new Tag("t4");
		
		t1.setBooks(Arrays.asList(new Book[] {b1, b2}));
		t3.setBooks(Arrays.asList(new Book[] {b1, b2, b3}));
		t4.setBooks(Arrays.asList(new Book[] {b4}));
		
		Arrays.asList(new Tag[] {t1, t2, t3, t4}).forEach(tagService::save);
		
		Book delBook = bookService.findById(1);
		System.err.println(delBook);
		delBook.getTags().forEach(System.err::println);
		bookService.delete(delBook);
		
		Tag delTag = tagService.findById(3);
		System.err.println(delTag);
		delTag.getBooks().forEach(System.err::println);
		tagService.delete(delTag);
	}
}
