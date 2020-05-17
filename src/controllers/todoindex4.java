package controllers;

import java.io.IOException;
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
 * Servlet implementation class DestroyServlet
 */
@WebServlet("/todoindex2")
public class todoindex4 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public todoindex4() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	EntityManager em = DBUtil.createEntityManager();

            String type2 = request.getParameter("type");
            Integer type = Integer.valueOf(type2);

            List<Todo> todos;

            if(type == 0){
            	 todos = em.createNamedQuery("getAlltodos", Todo.class) .getResultList();


            } else if (type == 1){
            	 todos = em.createNamedQuery("getjobtodos", Todo.class) .getResultList();


            } else if (type == 2){
            	 todos = em.createNamedQuery("getprivatetodos", Todo.class) .getResultList();


            } else {
            	 todos = em.createNamedQuery("getAlltodos", Todo.class) .getResultList();

            }

            em.close();

            request.setAttribute("todos", todos);
            request.setAttribute("selecttype", type);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/todos/index.jsp");
            rd.forward(request, response);
    }

}
