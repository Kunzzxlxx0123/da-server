package com.spring.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.server.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	
	@Query(value="SELECT id,pId,name FROM Category")
	List<Category> findAll();
	
	
	
}
