<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>ユーザー　新規登録ページ</h2>

        <form method="POST" action="<c:url value='/usercreate' />">
            <c:import url="form.jsp" />
        </form>

        <p><input type="button" class="buttonclass" value="ユーザー一覧へ戻る"
			onclick="location.href='${pageContext.request.contextPath}/userindex'"></p>
    </c:param>
</c:import>