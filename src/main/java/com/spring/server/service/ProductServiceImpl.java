package com.spring.server.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.server.model.Images;
import com.spring.server.model.Product;
import com.spring.server.repository.ImageRepository;
import com.spring.server.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired 
	ProductRepository productRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private ImageRepository imageRepository;
	
	
	@Override
	public Product save(Product product) {
		
		return productRepository.save(product);
	}
	
	@Override
	@Transactional
	public Optional<Product> findById(Long id){
		
		Product product = productRepository.findById(id).orElseThrow();
		List<String> images = imageRepository.findByProductId(product.getId());
		
		product.setImages(images);
		
		return Optional.of(product);
	}
	
	@Override
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	@Override
	public List<Product> getPageProducts(Pageable pageable){
		
		Page<Product> pageProducts = productRepository.getPageProducts(pageable);
		List<Product> products = pageProducts.getContent();
		for (Product product : products) {
			product.setImages(imageRepository.findByProductId(product.getId()));
		}
		
		return products;
	}
}
