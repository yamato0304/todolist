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
 * Servlet implementation class DestroyServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	EntityManager em = DBUtil.createEntityManager();

            // セッションスコープからメッセージのIDを取得して
            // 該当のIDのメッセージ1件のみをデータベースから取得
            Todo t = em.find(Todo.class, Integer.parseInt(request.getParameter("id")));

            String content = request.getParameter("content");
            t.setcontent(content);

            String deadline = request.getParameter("deadline");
            Date deadline2 = Date.valueOf(deadline);
            t.setdeadline(deadline2);

            String type = request.getParameter("type");
            Integer type2 = Integer.valueOf(type);
            t.settype(type2);



            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();


            // indexページへリダイレクト
            response.sendRedirect(request.getContextPath() + "/todoindex");
        }
    }
