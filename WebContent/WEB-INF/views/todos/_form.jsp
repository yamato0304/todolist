<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<label for="title">内容</label><br />
<input type="text" name="content" value="${todo.content}" />
<br /><br />

<label for="content">期限</label><br />
<input type="text" name="deadline" value="${todo.deadline}" />
<br /><br />

<label for="type">種類</label><br />
<input type="text" name="type" value="${todo.type}" />
<br /><br />


<input type="hidden" name="_token" value="${_token}" />
<button class="buttonclass" type="submit">作成</button>