package com.spring.server.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="DA_CATEGORY")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CT_ID")
	private Long id;
	
	@Column(name = "CT_PID")
	private Long pId;
	
	@Column(name = "CT_NAME")
	private String name;
	
	
	
	@Transient
	private Set<Product> products = new HashSet<Product>();
	
	@Transient
	private List<Category> childs;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Category> getChilds() {
		return childs;
	}

	public void setChilds(List<Category> childs) {
		this.childs = childs;
		
	}
	
	

	public Category(Long pId, String name) {
		super();
		this.pId = pId;
		this.name = name;
	}

	public Category(Long id, Long pId, String name) {
		this.id = id;
		this.pId = pId;
		this.name = name;
	}
	
	public Category() {
	}


	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
}
