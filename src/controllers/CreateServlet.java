package controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Todo;
import utils.DBUtil;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String _token = (String) request.getParameter("_token");
		if (_token != null && _token.equals(request.getSession().getId())) {
			EntityManager em = DBUtil.createEntityManager();

			Todo t = new Todo();

			List<String> errors = new ArrayList<String>();

			String content = request.getParameter("content");
			Integer user_id = Integer.valueOf(request.getParameter("user_id"));
			String deadline = request.getParameter("deadline");
			Integer type = Integer.valueOf(request.getParameter("type"));

			if (content == null || content.equals("")) {
				errors.add("内容を入力してください");
			}
			if (deadline == null || deadline.equals("")) {
				errors.add("期限を入力してください");
			}

			if (errors.size() > 0) {

				request.setAttribute("_token", request.getSession().getId());
				request.setAttribute("todo", t);
				request.setAttribute("errors", errors);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/todos/new.jsp");
				rd.forward(request, response);

			} else {

				Date deadline2 = Date.valueOf(deadline);

				t.setcontent(content);
				t.setUserid(user_id);
				t.setdeadline(deadline2);
				t.settype(type);

				em.getTransaction().begin();
				em.persist(t);
				em.getTransaction().commit();
				em.close();

				response.sendRedirect(request.getContextPath() + "/todoindex");

			}

		}
	}
}
