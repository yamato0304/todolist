package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Todo;
import models.User;
import utils.Searchtype;

/**
 * Servlet implementation class todoindex
 */
@WebServlet("/todoindex")
public class todoindex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public todoindex() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Todo> todos;

		HttpSession session = ((HttpServletRequest)request).getSession();

		User e = (User)session.getAttribute("login_user");

		Integer user_id = e.getId();




		String id = request.getParameter("id");
		if (id == null) {
			id = "0";


		}
		todos = Searchtype.search(Integer.valueOf(id),user_id);
		request.setAttribute("selecttype", id);
		request.setAttribute("todos", todos);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/todos/index.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer type = Integer.valueOf(request.getParameter("type"));

		Integer user_id = Integer.valueOf(request.getParameter("id"));

		List<Todo> todos;

		todos = Searchtype.search(type,user_id);

		request.setAttribute("todos", todos);
		request.setAttribute("selecttype", type);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/todos/index.jsp");
		rd.forward(request, response);
	}
}