package com.spring.server.model;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jdk.jfr.Timestamp;

@Entity
@Table(name = "DA_PRODUCT")
public class Product {

	
	@Id
	@Column(name = "PD_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "PD_NAME")
	private String name;
	
	@Column(name = "PD_PRICE")
	private Long price;
	
	@Column(name = "PD_NUMBER")
	private Long number;
	
	@Column(name = "PD_LIKE")
	private long likeCount;
	
	@Column(name = "CPU")
	private String cpu;
	
	@Column(name = "RAM")
	private String ram;
	
	@Column(name ="HARD_DISK")
	private String hardDisk;
	
	@Column(name ="GRAPHICS")
	private String graphics;
	
	@Column(name = "DISPLAY")
	private String display;
	
	@Column(name ="STATUS")
	private String status;
	
	@Column(name ="DESCRIPTION")
	private String description;
	
	
	
	@Column(name = "CREATED_BY")
	@CreatedBy
	private Long creator;
	
	@Column(name = "CREATED_DATE")
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_date;
	
	@Column(name = "LAST_MODIFIED_DATE")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified_date;
	
	@Column(name = "LAST_MODIFIED_BY")
	@LastModifiedBy
	private Long modifitor;
	
	@Transient
	private Set<Category> categories = new HashSet<Category>();

	@Transient
	private List<String> images = new ArrayList<String>();
	
	public Set<Category> getCategories() {
		return categories;
	}
	
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	

	public Product(Long id, String name, Long price, Long number, long likeCount, String cpu, String ram,
			String hardDisk, String graphics, String display, String status, String description, Long creator,
			Date created_date, Date modified_date, Long modifitor, Set<Category> categories, List<String> images) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.number = number;
		this.likeCount = likeCount;
		this.cpu = cpu;
		this.ram = ram;
		this.hardDisk = hardDisk;
		this.graphics = graphics;
		this.display = display;
		this.status = status;
		this.description = description;
		this.creator = creator;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.modifitor = modifitor;
		this.categories = categories;
		this.images = images;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getHardDisk() {
		return hardDisk;
	}

	public void setHardDisk(String hardDisk) {
		this.hardDisk = hardDisk;
	}

	public String getGraphics() {
		return graphics;
	}

	public void setGraphics(String graphics) {
		this.graphics = graphics;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public long getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(long likeCount) {
		this.likeCount = likeCount;
	}

	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getModified_date() {
		return modified_date;
	}

	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

	public Long getModifitor() {
		return modifitor;
	}

	public void setModifitor(Long modifitor) {
		this.modifitor = modifitor;
	}

	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
}
