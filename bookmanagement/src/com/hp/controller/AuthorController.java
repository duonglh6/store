package com.hp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.entity.AuthorEntity;
import com.hp.model.AuthorModel;
import com.hp.service.AuthorService;

/**
 * Servlet implementation class AuthorController
 */
@WebServlet("/AuthorController")
public class AuthorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AuthorService authorService = new AuthorService();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthorController() {
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
			theCommand = "LIST";
		}
		switch (theCommand) {
		case "ADD":
			addNewAuthor(request, response);
		case "DELETE":
			deleteAuthor(request, response);
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

	public void showAll(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<AuthorModel> listAuthor = authorService.getRevenueByAuthor();
			request.setAttribute("listAuthor", listAuthor);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/author/listAuthor.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteAuthor(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("authorId"));
		try {
			authorService.deleteAuthor(id);
			showAll(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addNewAuthor(HttpServletRequest request, HttpServletResponse response) {

		try {
			String name = request.getParameter("authorName");
			String dateString = request.getParameter("date");
			Date dob = sdf.parse(dateString);
			int id;
			try {
				id = authorService.generateId();
				AuthorEntity author = new AuthorEntity(id, name, dob);
				authorService.addNewAuthor(author);
				showAll(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
