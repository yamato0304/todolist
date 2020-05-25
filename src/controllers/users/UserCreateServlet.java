package controllers.users;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import models.validators.EmployeeValidator;
import utils.DBUtil;
import utils.EncryptUtil;

/**
 * Servlet implementation class UserCreateServlet
 */
@WebServlet("/usercreate")
public class UserCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserCreateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String _token = (String) request.getParameter("_token");
		if (_token != null && _token.equals(request.getSession().getId())) {
			EntityManager em = DBUtil.createEntityManager();

			Integer admin = Integer.valueOf(request.getParameter("admin"));

			User e = new User();

			e.setName(request.getParameter("name"));
			e.setPassword(EncryptUtil.getPasswordEncrypt(request.getParameter("password"),
					(String) this.getServletContext().getAttribute("salt")));
			e.setAdmin_flag(Integer.parseInt(request.getParameter("admin_flag")));

			e.setDelete_flag(0);

			List<String> errors = EmployeeValidator.validate(e, true);
			if (errors.size() > 0) {
				em.close();

				request.setAttribute("_token", request.getSession().getId());
				request.setAttribute("user", e);
				request.setAttribute("errors", errors);

				if (admin == 0) {

					 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/employees/new_notadmin.jsp");
			            rd.forward(request, response);

				}
				if (admin == 1) {

					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/employees/new.jsp");
		            rd.forward(request, response);
				}

			} else {
				em.getTransaction().begin();
				em.persist(e);
				em.getTransaction().commit();
				em.close();
				request.getSession().setAttribute("flush", "登録が完了しました。");

				response.sendRedirect(request.getContextPath() + "/userindex");
			}
		}
	}

}