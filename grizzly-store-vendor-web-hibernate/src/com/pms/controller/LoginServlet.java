package com.pms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pms.dao.LoginDaoHibernate;
import com.pms.dao.LoginDaoImpl;
import com.pms.java.ApplicationException;
import com.pms.pojo.LoginPojo;
import com.pms.service.LoginService;
import com.pms.service.LoginServiceImpl;
import com.pms.service.ProductService;
import com.pms.service.ProductServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		LoginService service=new LoginServiceImpl();
		String name=request.getParameter("user");
        String password=request.getParameter("pass");

        LoginPojo pojo=new LoginPojo();
        pojo.setUsername(name);

        //LoginDaoHibernate fetch=new LoginDaoImpl();
        pojo=service.fetchUserDetails(pojo);
        
        if(pojo.getStatus()==null)
        {
      	  RequestDispatcher rd=request.getRequestDispatcher("LoginUser.jsp");
            rd.forward(request, response);            	  
        }
        else if(pojo.getStatus().equals("enabled"))
               
        {
           if(pojo.getPassword().equals(password))
               {                                           
                     HttpSession session=request.getSession();
                     session.setAttribute("user", name);
                     session.setAttribute("role", pojo.getRole());
                     session.setAttribute("rating", pojo.getRating());
                     session.setAttribute("contact", pojo.getContact());
                     session.setAttribute("address", pojo.getAddress());
                     session.removeAttribute("attempt");
         			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("Layout.jsp");
         			 requestDispatcher.forward(request, response);                      
               }
           else
               {
               HttpSession session=request.getSession();
               String user=(String) session.getAttribute("user");
               if(request.getParameter("user").equals(user))
               {
                  	 String attempt=(String)session.getAttribute("attempt");
                  	 System.out.println(attempt);
                  	 			if(attempt==null)
                  	 			{
                                      session.setAttribute("user", name);
                                      session.setAttribute("attempt", "1");
                                      RequestDispatcher rd=request.getRequestDispatcher("LoginUser.jsp");
                                      rd.forward(request, response);
                  	 			}
                  	 			else if(attempt.equals("1"))
                                   {
                  	 				int attemptInt=Integer.parseInt(attempt);
                                  	 session.setAttribute("attempt", (++attemptInt)+"");
                                       RequestDispatcher rd=request.getRequestDispatcher("LoginUser.jsp");
                                       rd.forward(request, response); 
                                  	 
                                  	 	
                                          
                                   }
                                   else
                                   {
                                  	 session.invalidate();
                                  	 //LoginDaoHibernate lock=new LoginDaoImpl();
                                  	pojo=service.loginLock(pojo);
                                       RequestDispatcher rd=request.getRequestDispatcher("AccountLocked.html");
                                       rd.forward(request, response);  
                                   }
                     
                      
                 }
          
                 else
                 {
                     session.setAttribute("user", name);
                     session.setAttribute("attempt", "1");
                     RequestDispatcher rd=request.getRequestDispatcher("LoginUser.jsp");
                     rd.forward(request, response); 
                }}
               
                
         }
        
        else
        {
               RequestDispatcher rd=request.getRequestDispatcher("AccountLocked.html");
               rd.forward(request, response); 
         }}
	catch(ApplicationException ae)
	{
		 RequestDispatcher rd=request.getRequestDispatcher("ApplicationError.jsp");
         rd.forward(request, response); 
	}

}}
