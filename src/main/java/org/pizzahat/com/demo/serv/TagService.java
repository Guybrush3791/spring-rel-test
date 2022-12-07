package org.pizzahat.com.demo.serv;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.pizzahat.com.demo.pojo.Tag;
import org.pizzahat.com.demo.repo.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class TagService {

	@Autowired
	private TagRepo tagRepo;
	
	public void save(Tag tag) {
		
		tagRepo.save(tag);
	}
	public void delete(Tag tag) {
		
		tagRepo.delete(tag);
	}
	public List<Tag> findAll() {
		
		return tagRepo.findAll();
	}
	@Transactional
	public Tag findById(int id) {
		
		Tag tag = tagRepo.findById(id).get();
		Hibernate.initialize(tag.getBooks());
		
		return tag;
	}
}
