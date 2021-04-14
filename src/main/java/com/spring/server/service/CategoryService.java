package com.spring.server.service;

import java.util.List;

import com.spring.server.model.Category;

public interface CategoryService {

	List<Category> findAll();

	List<Category> getListTree();

}
