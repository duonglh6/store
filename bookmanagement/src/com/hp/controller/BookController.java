package com.hp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.dao.AuthorBookDAO;
import com.hp.dao.CategoryDAO;
import com.hp.entity.AuthorBookEntity;
import com.hp.entity.BookEntity;
import com.hp.entity.CategoryEntity;
import com.hp.service.AuthorBookService;
import com.hp.service.AuthorService;
import com.hp.service.BookService;
import com.hp.service.CategoryService;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static BookService bookService = new BookService();
	public static CategoryService categoryService = new CategoryService();
	public static AuthorService authorService = new AuthorService();
	public static CategoryDAO categoryDAO = new CategoryDAO();
	public static AuthorBookService authorBookService = new AuthorBookService();
	public static AuthorBookDAO authorBookDAO = new AuthorBookDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getParameter("command");
		if (command == null) {
			command = "LIST";
		}
		switch (command) {
		case "LOAD":
			loadBookById(request, response);
			break;
		case "UPDATE":
			updateBook(request, response);
			break;
		case "NEW":
			newBook(request, response);
			break;
		case "ADD":
			addNewBook(request, response);
			break;
		case "DELETE":
			deleteBook(request, response);
		default:
			showAllBook(request, response);

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

	public static void showAllBook(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setAttribute("showAllBook", bookService.getListBook());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/management/listBook.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void newBook(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("listCategory", categoryService.getRevenueOfCategory());
			request.setAttribute("listAuthor", authorService.getRevenueByAuthor());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/book/addNewBook.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void addNewBook(HttpServletRequest request, HttpServletResponse response) {

		try {
			String bookName = request.getParameter("bookName");
			long soldNumber = Long.parseLong(request.getParameter("soldNumber"));
			double price = Double.parseDouble(request.getParameter("price"));
			int categoryID = Integer.parseInt(request.getParameter("category"));
			int id = bookService.generateId();
			CategoryEntity category = categoryDAO.findCategoryById(categoryID);
			BookEntity bookEntity = new BookEntity();
			bookEntity.setId(id);
			bookEntity.setCategory(category);
			bookEntity.setName(bookName);
			bookEntity.setPrice(price);
			bookEntity.setSoldNumber(soldNumber);

			bookService.addBook(bookEntity);
			String[] listAuthorId = request.getParameterValues("author");
			for (int i = 0; i < listAuthorId.length; i++) {
				int authorId = Integer.parseInt(listAuthorId[i]);
				int authorBookId = authorBookService.generateId();
				AuthorBookEntity authorBookEntity = new AuthorBookEntity(authorBookId, id, authorId, 1);
				authorBookDAO.addNewAuthorBook(authorBookEntity);
				showAllBook(request, response);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteBook(HttpServletRequest request, HttpServletResponse response) {
		try {
			int bookId = Integer.parseInt(request.getParameter("bookId"));
			bookService.deleteBook(bookId);
			authorBookService.deleteByBookId(bookId);
			showAllBook(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void loadBookById(HttpServletRequest request, HttpServletResponse response) {
		try {

			long id = Long.parseLong(request.getParameter("bookId"));
			request.setAttribute("loadBookById", bookService.findBookById(id));
			request.setAttribute("listCategory", categoryService.getRevenueOfCategory());
			request.setAttribute("listAuthor", authorService.getRevenueByAuthor());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/book/updateBookForm.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void updateBook(HttpServletRequest request, HttpServletResponse response) {
		try {
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		int id = Integer.parseInt(request.getParameter("bookId"));
		CategoryEntity category = categoryService.findCategoryById(categoryId);
		long soldNumber = Long.parseLong(request.getParameter("soldNumber"));
		String[] authorId = request.getParameterValues("authorId");
		BookEntity bookEntity = new BookEntity(id, name, category, soldNumber, price);
		authorBookService.deleteByBookId(id);
		for(int i=0; i<authorId.length; i++){
			int authorID = Integer.parseInt(authorId[i]);
			int authorBookId = authorBookService.generateId();
			AuthorBookEntity authorBook = new AuthorBookEntity(authorBookId, id, authorID, 1);
			authorBookService.addAuthorBook(authorBook);
		}
		bookService.addBook(bookEntity);
		showAllBook(request, response);
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
