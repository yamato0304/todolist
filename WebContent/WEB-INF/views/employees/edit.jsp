<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
	<c:param name="content">
		<c:choose>
			<c:when test="${user != null}">
				<h2>${user.name}さんのユーザー情報 編集ページ</h2>
				<p>（パスワードは変更する場合のみ入力してください）</p>
				<form method="POST" action="<c:url value='/userupdate' />">
					<label for="name">氏名</label> <br /> <input type="text" name="name"
						value="${user.name}" /> <br /> <br /> <label for="password">パスワード</label>
					<br /> <input type="text" name="password"  />
					<br /> <br /> <label for="admin_flag">権限</label> <br /> <select
						name="admin_flag">
						<option value="0"
							<c:if test="${employee.admin_flag == 0}"> selected</c:if>>一般</option>
						<option value="1"
							<c:if test="${employee.admin_flag == 1}"> selected</c:if>>管理者</option>
					</select>
					<input type="hidden" name="_token" value="${_token}" />
					<br />
					<br />
					<button class="buttonclass" type="submit">変更</button>
				</form>



				<p>
				<input type="button" class="buttonclass" value="ユーザー情報削除"
			onclick="confirmDestroy();">
				</p>
				<form method="POST" action="<c:url value='/userdestroy' />">
					<input type="hidden" name="_token" value="${_token}" />
				</form>
				<script>
					function confirmDestroy() {
						if (confirm("本当に削除してよろしいですか？")) {
							document.forms[1].submit();
						}
					}
				</script>
			</c:when>
			<c:otherwise>
				<h2>お探しのデータは見つかりませんでした。</h2>
			</c:otherwise>
		</c:choose>

		<p>
		<input type="button" class="buttonclass" value="一覧に戻る"
			onclick="location.href='${pageContext.request.contextPath}/userindex'">

		</p>
	</c:param>
</c:import>