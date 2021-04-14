package com.spring.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.server.model.Category;
import com.spring.server.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	CategoryService categoryServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<Category>> getTreeCategory() {
		
		return new ResponseEntity<List<Category>>(categoryServiceImpl.getListTree(), HttpStatus.OK);
	}
}
