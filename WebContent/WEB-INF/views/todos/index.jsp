<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="controllers.Type" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <ul>
            <c:forEach var="todo" items="${todos}">
                <li>
                     <form method="POST" action="${pageContext.request.contextPath}/edit">

                     <input type="text"style="display:none" name="id" value="${todo.id}" />
                     <input type="text" name="content" value="${todo.content}" />
                     <input type="text" name="deadline" size="7" value="${todo.deadline}" />
                     <input type="text" name="type"  style="width: 10px;"value="${todo.type}" />

                     <c:out  value="${todo.gettypename()}" />
                     <button  class="buttonclass" type="submit">内容変更</button>
                     <input class="buttonclass" type= "button" value="削除" onclick ="location.href='${pageContext.request.contextPath}/destroy?id=${todo.id}'">

                     </form>

                </li>
            </c:forEach>
        </ul>

        <form method="POST" action="${pageContext.request.contextPath}/todoindex2">
        	<div>
        		 <input type="radio" id="all" name="type" value="0">
        		 <label for="typechoice1">全て</label>

        		 <input type="radio" id="type1" name="type" value="1">
         		<label for="typechoice2">仕事</label>

   				 <input type="radio" id="type2"name="type" value="2">
                <label for="typechoice3">プライベート</label>
		   </div>
  			<div>
    			<button  class="buttonclass" type="submit">抽出</button>
 		  </div>
		</form>

        <br>
        <input type= "button" class="buttonclass" value="新規ToDo作成" onclick ="location.href='${pageContext.request.contextPath}/new'">

    </c:param>
</c:import>