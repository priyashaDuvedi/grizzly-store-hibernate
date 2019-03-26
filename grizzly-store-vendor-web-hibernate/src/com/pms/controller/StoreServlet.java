package com.pms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pms.dao.LoginDao;
import com.pms.dao.LoginDaoHibernate;
import com.pms.dao.LoginDaoImpl;
import com.pms.dao.ProductDao;
import com.pms.dao.ProductDaoHibernate;
import com.pms.dao.ProductDaoImpl;
import com.pms.pojo.LoginPojo;
import com.pms.pojo.ProductPojo;

@WebServlet("/StoreServlet")
public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("Login") != null) {

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("LoginServlet");
			requestDispatcher.forward(request, response);

		}

		if (request.getParameter("Add") != null) {

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddServlet");
			requestDispatcher.forward(request, response);
		}

		if (request.getParameter("AddProduct") != null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddProduct.html");
			requestDispatcher.forward(request, response);

		}

		if (request.getParameter("display") != null) {

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("DisplayServlet");
			requestDispatcher.forward(request, response);
		}

		if (request.getParameter("idManage") != null) {

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ManageServlet");
			requestDispatcher.include(request, response);

		}

		if (request.getParameter("Logout") != null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("LogoutServlet");
			requestDispatcher.forward(request, response);
		}

		if (request.getParameter("id") != null) {

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("RemoveServlet");
			requestDispatcher.forward(request, response);

		}
		if(request.getParameter("Update")!=null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("UpdateServlet");
			requestDispatcher.forward(request, response);

		}
	}
}
