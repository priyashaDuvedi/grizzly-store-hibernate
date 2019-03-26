package com.pms.service;

import java.util.ArrayList;

import com.pms.java.ApplicationException;
import com.pms.pojo.ProductPojo;

public interface ProductService {
	
	public ArrayList fetchProductDetails() throws ApplicationException; 	
	public void addProductDetails(ProductPojo pojo) throws ApplicationException;
	public void removeProduct(int id) throws ApplicationException ;
	public int updateStock(ProductPojo pojo) throws ApplicationException; 

}
