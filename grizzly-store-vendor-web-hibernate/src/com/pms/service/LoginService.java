 package com.pms.service;


import com.pms.java.ApplicationException;
import com.pms.pojo.LoginPojo;

public interface LoginService {
	
	public LoginPojo fetchUserDetails(LoginPojo pojo) throws ApplicationException ;
	public LoginPojo loginLock (LoginPojo pojo) throws ApplicationException ;

}
