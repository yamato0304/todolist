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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */



        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	 EntityManager em = DBUtil.createEntityManager();

        	 List<Todo> todos;

             String id2 = request.getParameter("id");

             if(id2==null) {
            	 todos = em.createNamedQuery("getAlltodos", Todo.class) .getResultList();
            	 request.setAttribute("selecttype", "0");

            	} else {

            		Integer id = Integer.valueOf(id2);

            		if(id == 0){
            			todos = em.createNamedQuery("getAlltodos", Todo.class) .getResultList();
            			request.setAttribute("selecttype", "0");


            			} else if (id == 1){
            				todos = em.createNamedQuery("getjobtodos", Todo.class) .getResultList();
            				request.setAttribute("selecttype", "1");


            			} else if (id == 2){
            				todos = em.createNamedQuery("getprivatetodos", Todo.class) .getResultList();
            				request.setAttribute("selecttype", "2");

            			} else {
            				todos = em.createNamedQuery("getAlltodos", Todo.class) .getResultList();
            				request.setAttribute("selecttype", "0");

            	      }

             }

            request.setAttribute("todos", todos);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/todos/index.jsp");
            rd.forward(request, response);
        }
    }