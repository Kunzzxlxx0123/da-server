package com.spring.server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.server.model.Product;


public interface ProductService {

	Product save(Product product);

	Optional<Product> findById(Long id);

	List<Product> findAll();

	List<Product> getPageProducts(Pageable pageable);

}
