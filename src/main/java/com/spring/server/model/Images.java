package com.spring.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "DA_IMAGE")
@Entity
public class Images {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	@Column(name = "LINK")
	private String url;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductIdd(Long productId) {
		this.productId = productId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Images(Long id, Long product_id, String url) {
		this.id = id;
		this.productId = product_id;
		this.url = url;
	}
	
	public Images() {
		// TODO Auto-generated constructor stub
	}
}
