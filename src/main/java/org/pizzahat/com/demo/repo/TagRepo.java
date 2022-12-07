package org.pizzahat.com.demo.repo;

import org.pizzahat.com.demo.pojo.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepo extends JpaRepository<Tag, Integer> {
	 
}
                                                                               