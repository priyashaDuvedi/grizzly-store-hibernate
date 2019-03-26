package com.pms.dao;

import com.pms.java.ApplicationException;
import com.pms.pojo.LoginPojo;

public interface LoginDaoHibernate {

	
	public LoginPojo fetchUserDetails(LoginPojo pojo) throws ApplicationException;
	public LoginPojo loginLock(LoginPojo pojo) throws ApplicationException;
}
