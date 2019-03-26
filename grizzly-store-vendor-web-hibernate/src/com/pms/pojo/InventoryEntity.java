package com.pms.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="inventory_management")
public class InventoryEntity implements Serializable{
	

	
	
	@Column(name="inventory_buffer")
	private String inventoryBuffer;
	
	@Column(name="inventory_stock")
	private String inventoryStock;
	
	@Id
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="product_id")
	private ProductEntity product;

	

	
	public String getInventoryBuffer() {
		return inventoryBuffer;
	}




	public void setInventoryBuffer(String inventoryBuffer) {
		this.inventoryBuffer = inventoryBuffer;
	}




	public String getInventoryStock() {
		return inventoryStock;
	}




	public void setInventoryStock(String inventoryStock) {
		this.inventoryStock = inventoryStock;
	}




	public ProductEntity getProduct() {
		return product;
	}




	public void setProduct(ProductEntity product) {
		this.product = product;
	}




	public InventoryEntity()
	{
		
	}
	

}
