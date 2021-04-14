package com.spring.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.server.model.Product;
import com.spring.server.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Value("${page.size}")
	private Integer pageSize;

	@GetMapping
	public ResponseEntity<List<Product>> getIndex(
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort){
		
		
		
		Sort sortable = null;
		switch (sort) {
		case "ASC":
			sortable = Sort.by("id").ascending();
			break;
		case "DESC":
			sortable = Sort.by("id").descending();
			break;
		default:
			sortable = Sort.by("id").ascending();
			break;
		}
		
		Pageable pageable = PageRequest.of(page, pageSize, sortable);
		
		try {
			List<Product> products =  productService.getPageProducts(pageable);
			return ResponseEntity.ok(products);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		
		try {
			return new ResponseEntity<Product>(
					productService.save(product), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getOne(@PathVariable(name="id") String id){
		try {
			return new ResponseEntity<Product>(
					productService.findById(Long.valueOf(id)).get(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
	}
}
