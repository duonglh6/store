package com.hp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.model.AuthorModel;
import com.hp.model.CategoryModel;
import com.hp.service.AuthorService;
import com.hp.service.CategoryService;

/**
 * Servlet implementation class BookStoreController
 */
@WebServlet("/BookStoreController")
public class BookStoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static AuthorService authorService = new AuthorService();
	public static CategoryService categoryService = new CategoryService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookStoreController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String theCommand = request.getParameter("command");
		if (theCommand == null) {
			theCommand = "List";
		}
		switch (theCommand) {
		case "TOP_REVENUE_BY_AUTHOR":
			getRevenueByAuthor(request, response);
			break;
		case "TOP_REVENUE_BY_CATEGORY":
			getRevenueByCategory(request, response);
			break;
		default:
			showAll(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static void getRevenueByAuthor(HttpServletRequest request, HttpServletResponse response) {

		try {
			List<AuthorModel> author = authorService.getRevenueByAuthor();
			request.setAttribute("getRevenueByAuthor", author);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/report/getRevenueByAuthor.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void getRevenueByCategory(HttpServletRequest request, HttpServletResponse response) {

		try {
			List<CategoryModel> category = categoryService.getRevenueOfCategory();
			request.setAttribute("getRevenueByCategory", category);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/report/getRevenueByCategory.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void showAll(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			List<CategoryModel> category = categoryService.getRevenueOfCategory();
			request.setAttribute("ListCategory", category);
			List<AuthorModel> author = authorService.getRevenueByAuthor();
			request.setAttribute("ListAuthor", author);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/report/report.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
