package com.hp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.entity.CategoryEntity;
import com.hp.model.CategoryModel;
import com.hp.service.CategoryService;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CategoryService categoryService = new CategoryService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryController() {
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
		case "DELETE":
			deleteCategory(request, response);
			break;
		case "ADD":
			addCategory(request, response);
		default:
			showAll(request, response);

		}
		// try {
		// List<CategoryModel> categoryModel = new
		// ArrayList<CategoryModel>(categoryService.getRevenueOfCategory());
		// request.setAttribute("list", categoryModel);
		// RequestDispatcher rqDispatcher =
		// request.getRequestDispatcher("/Category.jsp");
		// rqDispatcher.forward(request, response);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
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

	public static void showAll(HttpServletRequest request, HttpServletResponse response) {
		List<CategoryModel> listCategory;
		try {
			listCategory = categoryService.getRevenueOfCategory();
			request.setAttribute("listCategory", listCategory);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/category/listCategory.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void deleteCategory(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			int categoryID = Integer.parseInt(request.getParameter("categoryId"));
			categoryService.deleteCategoryById(categoryID);
			showAll(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void addCategory(HttpServletRequest request, HttpServletResponse response) {
		try {
			String name = request.getParameter("categoryName");
			int id = categoryService.generateId();
			CategoryEntity category = new CategoryEntity(id, name);
			categoryService.addCategory(category);
			showAll(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
