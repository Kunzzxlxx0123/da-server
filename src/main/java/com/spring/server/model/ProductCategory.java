package com.spring.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DA_PRODUCT_CATEGORY")
public class ProductCategory {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="PRODUCT_ID")
	private Long product_id;
	
	@Column(name="CATEGORY_ID")
	private Long category_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public ProductCategory(Long id, Long product_id, Long category_id) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.category_id = category_id;
	}

	
}
