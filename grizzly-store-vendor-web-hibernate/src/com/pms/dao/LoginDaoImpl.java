package com.pms.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pms.java.ApplicationException;
import com.pms.pojo.LoginEntity;
import com.pms.pojo.LoginPojo;

public class LoginDaoImpl implements LoginDaoHibernate {
	
	public LoginPojo fetchUserDetails(LoginPojo pojo) throws ApplicationException
	{
		SessionFactory sf=null;
		Session session=null;
		try {
	 sf=HibernateUtil.getSessionFactory();
	 session=sf.openSession();
	
	System.out.println(pojo.getUsername());
	LoginEntity login=session.get(LoginEntity.class, pojo.getUsername());
	System.out.println(login);
	if(login!=null)
	{
		pojo.setPassword(login.getPassword());
		pojo.setAddress(login.getAddress());
		pojo.setContact(login.getContact());
		pojo.setRating(login.getRating());
		pojo.setRole(login.getRole());
		pojo.setStatus(login.getStatus());
	}
	}catch(HibernateException he)
		{
		ApplicationException ae=new ApplicationException(-1,he.getMessage());
		throw ae;
		}
		finally {
			session.close();	
		}
	
	
	return pojo ;
	}
	
 public LoginPojo loginLock(LoginPojo pojo) throws ApplicationException
	{SessionFactory sf=null;
	Session session=null;
	 try {
		 sf=HibernateUtil.getSessionFactory();
		 session=sf.openSession();
		Transaction tr=session.beginTransaction();
		LoginEntity login=session.get(LoginEntity.class, pojo.getUsername());
		login.setStatus("disabled");
		tr.commit();
		pojo.setStatus(login.getStatus());
	 }
	 catch(HibernateException he)
		{
		ApplicationException ae=new ApplicationException(-1,he.getMessage());
		throw ae;
		}
	 
	 finally {
		session.close();}
		return pojo;

}
}