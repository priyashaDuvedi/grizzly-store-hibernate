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
import com.pms.pojo.ProductPojo;
import com.pms.service.ProductService;
import com.pms.service.ProductServiceImpl;


@WebServlet("/ManageServlet")
public class ManageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductService service=new ProductServiceImpl();
		request.setAttribute("id", request.getParameter("idManage"));
		request.setAttribute("buffer", request.getParameter("buffer"));
		request.setAttribute("stock", request.getParameter("stock"));
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("UpdateStock.jsp");
		requestDispatcher.include(request, response);
		
	
	}}


