package utils;

import java.util.List;

import javax.persistence.EntityManager;

import models.Todo;

public class Searchtype {
	public static List<Todo> search(Integer type,Integer user_id){
		EntityManager em = DBUtil.createEntityManager();
		 List<Todo> todos;

		 if(type == 0){
        	 todos = em.createNamedQuery("getMyAlltodos", Todo.class).setParameter("user_id",user_id).getResultList();


        } else if (type == 1){
        	 todos = em.createNamedQuery("getMyjobtodos", Todo.class).setParameter("user_id",user_id) .getResultList();


        } else if (type == 2){
        	 todos = em.createNamedQuery("getMyprivatetodos", Todo.class).setParameter("user_id",user_id) .getResultList();


        } else {
        	 todos = em.createNamedQuery("getMyAlltodos", Todo.class) .setParameter("user_id",user_id).getResultList();

        }

        em.close();
        return todos;
	}

}
