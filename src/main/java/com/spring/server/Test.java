package com.spring.server;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.server.model.Category;
import com.spring.server.repository.CategoryRepository;


public class Test {

	
	@Autowired
	CategoryRepository categoryRepository;
	
	static List<Category> categories = new ArrayList<Category>();
	
	public static void sortTree(List<Category> listTree){
		
		if(listTree != null && !listTree.isEmpty()) {
			for (Category category : listTree) {
				List<Category> listChild = categories.stream().filter(cat -> cat.getpId() == category.getId()).collect(Collectors.toList());
				category.setChilds(listChild);
				sortTree(category.getChilds());
			}
		}
	}
	
	public static void main(String[] args) {
		
//		List<Category> listTree = new ArrayList<Category>();
//		
//		Category parent1 = new Category(1L, 0L, "parent-1", null);
//		Category parent2 = new Category(2L, 0L, "parent-2", null);
//		Category child1 = new Category(3L, 1L, "child-1.1", null);
//		Category child2 = new Category(4L, 2L, "child-2.1", null);
//		Category child3 = new Category(5L, 2L, "child-2.2", null);
//		Category child4 = new Category(6L, 3L, "child-1.1.1", null);
//		
//		categories.add(parent1);
//		categories.add(parent2);
//		categories.add(child1);
//		categories.add(child2);
//		categories.add(child3);
//		categories.add(child4);
//		
//		listTree.add(parent1);
//		listTree.add(parent2);
//		
//		sortTree(categories);
//		
//		System.out.println(listTree);
		
	}
}
