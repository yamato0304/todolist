package controllers;

import java.io.IOException;
import java.sql.Date;

import javax.persistence.EntityManager;
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
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Todo t = new Todo();

            String content = request.getParameter("content");
            t.setcontent(content);

            Integer user_id = Integer.valueOf(request.getParameter("user_id"));
            t.setUserid(user_id);


            Date deadline = Date.valueOf(request.getParameter("deadline"));
            t.setdeadline(deadline);


            Integer type = Integer.valueOf(request.getParameter("type"));
            t.settype(type);

            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            em.close();

            response.sendRedirect(request.getContextPath() + "/todoindex");
        }
    }

}