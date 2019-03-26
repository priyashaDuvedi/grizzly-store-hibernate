package com.pms.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pms.dao.HibernateUtil;
import com.pms.dao.LoginDaoHibernate;
import com.pms.dao.LoginDaoImpl;
import com.pms.dao.ProductDaoHibernate;
import com.pms.dao.ProductDaoImpl;
import com.pms.java.ApplicationException;
import com.pms.pojo.InventoryEntity;
import com.pms.pojo.ProductEntity;
import com.pms.pojo.ProductPojo;

public class ProductServiceImpl implements ProductService {
	
	public  ArrayList fetchProductDetails() throws ApplicationException
	{
		ProductDaoHibernate service=new ProductDaoImpl();
		ArrayList productDetails=new ArrayList();
		productDetails=service.fetchProductDetails();
		return productDetails;
	}
	
	public void addProductDetails(ProductPojo pojo) throws ApplicationException {
		ProductDaoHibernate service=new ProductDaoImpl();
	   service.addProductDetails(pojo);
		
		
	}
	public void removeProduct(int id) throws ApplicationException{
		ProductDaoHibernate service=new ProductDaoImpl();
		service.removeProduct(id);
		

	}
		 
		public int updateStock(ProductPojo pojo) throws ApplicationException {
			
			ProductDaoHibernate service=new ProductDaoImpl();
			int affectedProduct=service.updateStock(pojo);
			return affectedProduct;
		}

}
