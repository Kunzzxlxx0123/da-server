package com.spring.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.server.model.Category;
import com.spring.server.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	CategoryRepository categoryRepositoryImpl;
	
	
	@SuppressWarnings("unchecked" )
	@Override
	@Transactional
	public List<Category> findAll(){
		Query query = entityManager.createNativeQuery("SELECT c.CT_ID,c.CT_PID,c.CT_NAME FROM DA_CATEGORY c");
 		List<Object[]> objects = query.getResultList();
 		List<Category> categories = new ArrayList<Category>();
 		
 		objects.forEach(ob -> {
 			categories.add(new Category(Long.valueOf(String.valueOf(ob[0])), Long.valueOf(String.valueOf(ob[1])), String.valueOf(ob[2])));
 		});
		return categories;
	}
	
	public void sortTree(List<Category> data, List<Category> listTree){
		if(listTree != null && !listTree.isEmpty()) {
			for (Category category : listTree) {
				List<Category> listChild = data.stream().filter(cat -> cat.getpId() == category.getId()).collect(Collectors.toList());
				category.setChilds(listChild);
				sortTree(data, category.getChilds());
			}
		}
	}
	
	@Override
	public List<Category> getListTree(){
		
		List<Category> data = this.findAll();
		List<Category> root = data.stream().filter(category -> category.getpId() == 0L).collect(Collectors.toList());
		
		sortTree(data, root);
		return root;
	}
}
