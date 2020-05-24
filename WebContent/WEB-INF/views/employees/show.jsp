<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${user != null}">
                <h2>${user.name} のユーザー情報　詳細ページ</h2>

                <table>
                    <tbody>

                        <tr>
                            <th>氏名</th>
                            <td><c:out value="${user.name}" /></td>
                        </tr>
                        <tr>
                            <th>権限</th>
                            <td>
                                <c:choose>
                                    <c:when test="${user.admin_flag == 1}">管理者</c:when>
                                    <c:otherwise>一般</c:otherwise>
                                </c:choose>
                            </td>
                        </tr>

                    </tbody>
                </table>

                <p><a href="<c:url value='/useredit?id=${user.id}' />">この従業員情報を編集する</a></p>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value='/userindex' />">一覧に戻る</a></p>
    </c:param>
</c:import>