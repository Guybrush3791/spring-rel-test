package org.pizzahat.com.demo.repo;

import org.pizzahat.com.demo.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
	 
}
                                                                               