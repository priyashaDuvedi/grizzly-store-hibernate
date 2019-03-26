package com.pms.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pms.dao.HibernateUtil;
import com.pms.dao.LoginDaoHibernate;
import com.pms.dao.LoginDaoImpl;
import com.pms.java.ApplicationException;
import com.pms.pojo.LoginEntity;
import com.pms.pojo.LoginPojo;

public class LoginServiceImpl implements LoginService {

	public LoginPojo fetchUserDetails(LoginPojo pojo) throws ApplicationException
	{
	LoginDaoHibernate service=new LoginDaoImpl();
	pojo=service.fetchUserDetails(pojo);
	return pojo;
	}
	
 public  LoginPojo loginLock(LoginPojo pojo) throws ApplicationException
	{
	 LoginDaoHibernate service=new LoginDaoImpl();
	 pojo=service.loginLock(pojo);
	 return pojo;
}
	
}
