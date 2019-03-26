package com.pms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pms.dao.ProductDaoHibernate;
import com.pms.dao.ProductDaoImpl;
import com.pms.java.ApplicationException;
import com.pms.pojo.ProductPojo;
import com.pms.service.ProductService;
import com.pms.service.ProductServiceImpl;


@WebServlet("/RemoveServlet")
public class RemoveServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ProductService service=new ProductServiceImpl();
			String id = request.getParameter("id");
			//ProductDaoHibernate remove = new ProductDaoImpl();
			service.removeProduct(Integer.parseInt(id));

			
				request.setAttribute("remove", "remove");
				//ProductDaoHibernate fetch = new ProductDaoImpl();
				ArrayList<ProductPojo> arrayList =service.fetchProductDetails();
				request.setAttribute("arrayList", arrayList);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("FetchProduct.jsp");
				requestDispatcher.forward(request, response);
		}
		catch(ApplicationException ae)
		{
			 RequestDispatcher rd=request.getRequestDispatcher("ApplicationError.jsp");
	         rd.forward(request, response); 
		}
	}

}
