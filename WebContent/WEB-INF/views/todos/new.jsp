<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>新規ToDo</h2>

        <form method="POST" action="${pageContext.request.contextPath}/create">
            <label for="title">内容</label><br />
            <input type="text" name="content" value="${todo.content}" />
            <br /><br />

			<label for="content">期限</label><br />
			<input type="text" name="deadline" value="${todo.deadline}" />
			<br /><br />

			<label for="type">種類</label><br />
			<select name="type">
				<option value="1">仕事</option>
				<option value="2">プライベート</option>
			</select>
			<br /><br />

			<input type="hidden" name="_token" value="${_token}" />
			<button class="buttonclass" type="submit">作成</button>
        </form>
        <br>
        <p><input class="buttonclass"  type= "button" value="一覧に戻る" onclick ="location.href='${pageContext.request.contextPath}/todoindex'"></p>

    </c:param>
</c:import>