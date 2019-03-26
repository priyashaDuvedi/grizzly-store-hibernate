package com.pms.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_management")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_brand")
	private String productBrand;
	
	@Column(name="product_description")
	private String productDescription;
	
	@Column(name="product_category")
	private String productCategory;
	
	@Column(name="product_rating")
	private String productRating;
	
	@OneToOne(mappedBy="product" ,cascade=CascadeType.ALL)
	private InventoryEntity inventoryId;
	
	@Column(name="product_price")
	private String productPrice;
	
	

	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getProductBrand() {
		return productBrand;
	}



	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}



	public String getProductDescription() {
		return productDescription;
	}



	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}



	public String getProductCategory() {
		return productCategory;
	}



	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}



	public String getProductRating() {
		return productRating;
	}



	public void setProductRating(String productRating) {
		this.productRating = productRating;
	}



	public InventoryEntity getInventoryId() {
		return inventoryId;
	}



	public void setInventoryId(InventoryEntity inventoryId) {
		this.inventoryId = inventoryId;
	}



	public String getProductPrice() {
		return productPrice;
	}



	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}



	public ProductEntity()
	{
		
	}
	
	
}
