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

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ProductService service=new ProductServiceImpl();
			
			ProductPojo pojo = new ProductPojo();
			
			pojo.setProductName(request.getParameter("name"));
			pojo.setProductCategory(request.getParameter("category"));
			pojo.setProductBrand(request.getParameter("brand"));
			pojo.setProductDescription(request.getParameter("description"));
			pojo.setProductRating(request.getParameter("rating"));
			pojo.setProductPrice(request.getParameter("price"));
			pojo.setProductBuffer(request.getParameter("buffer"));
		
			//ProductDaoHibernate add = new ProductDaoImpl();
			//int rowAffected = ProductDao.addProductDetails(pojo);
			service.addProductDetails(pojo);
			System.out.println("Added");
			//ProductDaoHibernate fetch = new ProductDaoImpl();
			ArrayList<ProductPojo> arrayList =service.fetchProductDetails();
			
			request.setAttribute("arrayList", arrayList);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("FetchProduct.jsp");
			System.out.println("fetched");
			requestDispatcher.include(request, response);
		}
		catch(ApplicationException ae)
		{
			 RequestDispatcher rd=request.getRequestDispatcher("ApplicationError.jsp");
	         rd.forward(request, response); 
		}
	}

}
