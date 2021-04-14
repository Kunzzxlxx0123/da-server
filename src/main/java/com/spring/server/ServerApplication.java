package com.spring.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.server.model.Category;
import com.spring.server.model.Product;
import com.spring.server.repository.CategoryRepository;
import com.spring.server.repository.ProductRepository;

@SpringBootApplication
public class ServerApplication implements CommandLineRunner{
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	

	@Override
	public void run(String... args) throws Exception {
//		List<Product> products = new ArrayList<Product>();
//		List<Category> categories = new ArrayList<Category>();
//		
//		Product p1 = new Product("Asus ROG", 38900000L, 5L, 0L, null, new Date(), new Date(), null, new HashSet<Category>());
//		Product p2 = new Product("Thinkpad X1 extreme gen 3", 38900000L, 5L, 0L, null, new Date(), new Date(), null, new HashSet<Category>());
//		Product p3 = new Product("Thinkpad X1 carbon gen 8", 38900000L, 5L, 0L, null, new Date(), new Date(), null, new HashSet<Category>());
//		Product p4 = new Product("Thinkpad X1 nano", 38900000L, 5L, 0L, null, new Date(), new Date(), null, new HashSet<Category>());
//		Product p5 = new Product("Dell XPS 15", 38900000L, 5L, 0L, null, new Date(), new Date(), null, new HashSet<Category>());
//		Product p6 = new Product("Dell XPS 13", 38900000L, 5L, 0L, null, new Date(), new Date(), null, new HashSet<Category>());
//		Product p7 = new Product("Dell XPS 17", 38900000L, 5L, 0L, null, new Date(), new Date(), null, new HashSet<Category>());
//		Product p8 = new Product("Macbook pro 2020", 38900000L, 5L, 0L, null, new Date(), new Date(), null, new HashSet<Category>());
//		Product p9 = new Product("HP elite book", 38900000L, 5L, 0L, null, new Date(), new Date(), null, new HashSet<Category>());
//		Product p10 = new Product("Asus zenbook", 38900000L, 5L, 0L, null, new Date(), new Date(), null, new HashSet<Category>());
//		
//		Category c1 = new Category(0L, "Lenovo", new HashSet<Product>());
//		Category c2 = new Category(0L, "Asus", new HashSet<Product>());
//		Category c3 = new Category(0L, "Dell", new HashSet<Product>());
//		Category c4 = new Category(0L, "Apple", new HashSet<Product>());
//		Category c5 = new Category(0L, "HP", new HashSet<Product>());
//		
//		p1.setCategories(new HashSet<Category>(Arrays.asList(c2)));
//		p2.setCategories(new HashSet<Category>(Arrays.asList(c1)));
//		p3.setCategories(new HashSet<Category>(Arrays.asList(c1)));
//		p4.setCategories(new HashSet<Category>(Arrays.asList(c1)));
//		p5.setCategories(new HashSet<Category>(Arrays.asList(c3)));
//		p6.setCategories(new HashSet<Category>(Arrays.asList(c3)));
//		p7.setCategories(new HashSet<Category>(Arrays.asList(c3)));
//		p8.setCategories(new HashSet<Category>(Arrays.asList(c4)));
//		p9.setCategories(new HashSet<Category>(Arrays.asList(c5)));
//		p10.setCategories(new HashSet<Category>(Arrays.asList(c2)));
//		
//		
//		c1.setProducts(new HashSet<Product>(Arrays.asList(p2, p3, p4)));
//		c2.setProducts(new HashSet<Product>(Arrays.asList(p1, p10)));
//		c3.setProducts(new HashSet<Product>(Arrays.asList(p5, p6, p7)));
//		c4.setProducts(new HashSet<Product>(Arrays.asList(p8)));
//		c5.setProducts(new HashSet<Product>(Arrays.asList(p9)));
//		
//		products.addAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
//		categories.addAll(Arrays.asList(c1, c2, c3, c4, c5));
//		
//		productRepository.saveAll(products);
//		categoryRepository.saveAll(categories);
		
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}
