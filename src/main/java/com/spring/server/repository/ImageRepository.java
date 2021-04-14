package com.spring.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.server.model.Images;

@Repository
public interface ImageRepository extends JpaRepository<Images, Long>{

	@Query("select i.url from Images i where i.productId=?1")
	List<String> findByProductId(Long productId);
}
