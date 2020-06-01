<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../layout/app.jsp">
	<c:param name="content">
		<h2>ユーザー 新規登録</h2>
		<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>

		<form method="POST" action="<c:url value='/usercreate' />">
			<label for="name">ログインID</label><br /> <input type="text" name="name"
				value="${employee.name}" /> <br />
			<br /> <label for="password">パスワード</label><br /> <input
				type="password" name="password" /> <br />
			<br />
			<input type="hidden" name="admin_flag" value="0" />
			<input type="hidden" name="_token" value="${_token}" />
			<input type="hidden" name="admin" value=0 />

			<button class="buttonclass" type="submit">登録</button>
		</form>

		<p>
		<input type="button" class="buttonclass" value="ログイン画面へ戻る"
			onclick="location.href='${pageContext.request.contextPath}/userlogin'">

		</p>
	</c:param>
</c:import>