package com.pms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pms.java.ApplicationException;
import com.pms.pojo.ProductPojo;
import com.pms.service.ProductService;
import com.pms.service.ProductServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			ProductService service=new ProductServiceImpl();
			ProductPojo pojo = new ProductPojo();
			
			pojo.setProductId(Integer.parseInt(request.getParameter("idManaged")));
			pojo.setProductBuffer(request.getParameter("buffer"));
			pojo.setProductStock(request.getParameter("stock"));
			
			//ProductDaoHibernate update = new ProductDaoImpl();
			int rowAffected = service.updateStock(pojo);
	
			if(rowAffected!=0) {
				request.setAttribute("display", "inventory");
				//ProductDaoHibernate fetch = new ProductDaoImpl();
				ArrayList<ProductPojo> arrayList =service.fetchProductDetails();
				request.setAttribute("arrayList", arrayList);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("FetchProduct.jsp");
				requestDispatcher.forward(request, response);
			}}
			catch(ApplicationException ae)
			{
				 RequestDispatcher rd=request.getRequestDispatcher("ApplicationError.jsp");
		         rd.forward(request, response); 
			}
	}

}
