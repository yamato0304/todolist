<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app.jsp">
	<c:param name="content">
		<h2>新規ToDo</h2>

		<c:if test="${errors != null}">
	<div id="flush_error">
		入力内容にエラーがあります。<br />
		<c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" />
			<br />
		</c:forEach>

	</div>
</c:if>

		<form method="POST" action="${pageContext.request.contextPath}/create">
            <input type="hidden" name="user_id" value="${sessionScope.login_user.id}" />
			<label for="title">内容</label><br /> <input
				type="text" name="content" value="${todo.content}" /> <br /> <br />
			<label for="content">期限</label><br /> <input type="date"
				name="deadline" value="${todo.deadline}" /> <br /> <br /> <label
				for="type">種類</label><br /> <select name="type">
				<option value="1">仕事</option>
				<option value="2">プライベート</option>
			</select> <br /> <br /> <input type="hidden" name="_token" value="${_token}" />
			<button class="buttonclass" type="submit">作成</button>
		</form>
		<br>
		<p>
			<input class="buttonclass" type="button" value="一覧に戻る"
				onclick="location.href='${pageContext.request.contextPath}/todoindex'">
		</p>

	</c:param>
</c:import>