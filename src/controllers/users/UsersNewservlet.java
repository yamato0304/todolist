package controllers.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;

/**
 * Servlet implementation class UsersNewservlet
 */
@WebServlet("/usernew")
public class UsersNewservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersNewservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 *
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("_token", request.getSession().getId());
		request.setAttribute("user", new User());

		Integer admin = Integer.valueOf(request.getParameter("admin"));

		if (admin == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/employees/new_notadmin.jsp");
			rd.forward(request, response);
		}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/employees/new.jsp");
			rd.forward(request, response);

		}

	}

