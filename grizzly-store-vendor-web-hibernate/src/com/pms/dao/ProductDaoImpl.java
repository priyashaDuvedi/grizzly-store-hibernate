package com.pms.dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.*;

import com.pms.java.ApplicationException;
import com.pms.pojo.InventoryEntity;
import com.pms.pojo.ProductEntity;
import com.pms.pojo.ProductPojo;

public class ProductDaoImpl implements ProductDaoHibernate {
	

	public  ArrayList fetchProductDetails() throws ApplicationException
	{
		
		ArrayList productDetails=null;
		SessionFactory sf=null;
		Session session=null;
		try {
		 sf=HibernateUtil.getSessionFactory();
		 session=sf.openSession();
		
	List list=session.createQuery("from ProductEntity").list();
		 productDetails=new ArrayList();
		 for(int i=0;i< list.size();i++)
			{

			 ProductEntity productEntity=(ProductEntity)list.get(i);
				ProductPojo pojo = new ProductPojo();
				pojo.setProductId(productEntity.getProductId());
				pojo.setProductName(productEntity.getProductName());
				pojo.setProductBrand(productEntity.getProductBrand());
				pojo.setProductDescription(productEntity.getProductDescription());
				pojo.setProductCategory(productEntity.getProductCategory());
				pojo.setProductRating(productEntity.getProductRating());
				pojo.setProductPrice(productEntity.getProductPrice());
				
				
				
				InventoryEntity inventoryId=productEntity.getInventoryId();
				 pojo.setProductBuffer(inventoryId.getInventoryBuffer());
					pojo.setProductStock(inventoryId.getInventoryStock());
					productDetails.add(pojo);
				
			}}
		catch(HibernateException he)
		{
		ApplicationException ae=new ApplicationException(-1,he.getMessage());
		throw ae;
		}
		finally {
			session.close();	
		}
		return productDetails;
	}
	
	public void addProductDetails(ProductPojo pojo) throws ApplicationException {
		
		SessionFactory sf=null;
		Session session=null;
		try {
		sf=HibernateUtil.getSessionFactory();
		 session=sf.openSession();
		Transaction tr=session.beginTransaction();
		 ProductEntity productEntity=new ProductEntity();
		 
		 productEntity.setProductName(pojo.getProductName());
		 productEntity.setProductBrand(pojo.getProductBrand());
		 productEntity.setProductDescription(pojo.getProductDescription());
		 productEntity.setProductCategory(pojo.getProductCategory());
		 productEntity.setProductRating(pojo.getProductRating());
		 productEntity.setProductPrice(pojo.getProductPrice());
		 session.save(productEntity);
		 tr.commit();
		 session.close();
		 
		 
	     session=sf.openSession();
		 tr=session.beginTransaction();
		 InventoryEntity inventoryEntity=new InventoryEntity();
		 inventoryEntity.setInventoryBuffer(pojo.getProductBuffer());
		 inventoryEntity.setInventoryStock("0");
		 inventoryEntity.setProduct(productEntity);
		 session.save(inventoryEntity);
		 tr.commit();}
		catch(HibernateException he)
		{
		ApplicationException ae=new ApplicationException(-1,he.getMessage());
		throw ae;
		}
		finally {
			session.close();	
		}
	}
	public void removeProduct(int id) throws ApplicationException {
		SessionFactory sf=null;
		Session session=null;
		try {
	 sf=HibernateUtil.getSessionFactory();
		session=sf.openSession();
		Transaction tr=session.beginTransaction();
        ProductEntity product = (ProductEntity) session.load(ProductEntity.class, id);
        session.delete(product);
        session.getTransaction().commit();
		}
		catch(HibernateException he)
		{
		ApplicationException ae=new ApplicationException(-1,he.getMessage());
		throw ae;
		}
		finally {
			session.close();	
		}

	}
		 
		public int updateStock(ProductPojo pojo) throws ApplicationException {
			SessionFactory sf=null;
			Session session=null;
			int affectedProduct;
			try {
			 sf=HibernateUtil.getSessionFactory();
			session=sf.openSession();
			Transaction tr=session.beginTransaction();
			 affectedProduct=session.createQuery("update InventoryEntity set inventoryStock=" +pojo.getProductStock()+ "where product_Id="+ pojo.getProductId()).executeUpdate();
			tr.commit();}
			
			catch(HibernateException he)
			{
			ApplicationException ae=new ApplicationException(-1,he.getMessage());
			throw ae;
			}
			finally {
				session.close();	
			}
			return affectedProduct;
		}
		
	}

