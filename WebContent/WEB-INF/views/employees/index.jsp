<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app.jsp">
	<c:param name="content">
		<c:if test="${flush != null}">
			<div id="flush_success">
				<c:out value="${flush}"></c:out>
			</div>
		</c:if>
		<h2>ユーザー一覧</h2>
		<table id="user_list">
			<tbody>
				<tr>
					<th>氏名</th>
					<th>操作</th>
				</tr>
				<c:forEach var="users" items="${users}" varStatus="status">
					<tr class="row${status.count % 2}">
						<td><c:out value="${users.name}" /></td>
						<td><c:choose>
								<c:when test="${users.delete_flag == 1}">
                                    （削除済み）
                                </c:when>
								<c:otherwise>
									<a href="<c:url value='/useredit?id=${users.id}' />">編集</a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div id="pagination">
			（全 ${users_count} 件）<br />

		</div>
		<input type="button" class="buttonclass" value="新規ユーザー登録"
			onclick="location.href='${pageContext.request.contextPath}/usernew?admin=1'">
		<input type="button" class="buttonclass" value="ToDo一覧へ戻る"
			onclick="location.href='${pageContext.request.contextPath}/todoindex'">


	</c:param>
</c:import>