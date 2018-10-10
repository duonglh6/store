package com.hp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hp.model.UserModel;
import com.hp.service.UserService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserService service = new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String email = request.getParameter("email");
			String pass = request.getParameter("password");
			// if (StringUtils.isEmptyOrWhitespaceOnly(email) &&
			// StringUtils.isEmptyOrWhitespaceOnly(pass)) {
			UserModel model = service.checkLogin(email, pass);
			if (model != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", model);
				request.setAttribute("message", "ok");
				response.sendRedirect("BookStoreController");
			} else {
				request.setAttribute("message", "thieu noi dung");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}
			// }

			// chuyen page
			// response.sendRedirect(arg0);

		} catch (Exception e) {
			request.setAttribute("message", "sai");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
	}

}
