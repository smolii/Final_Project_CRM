<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tasks</title>
<%@ include file="../fragments/relHead.jsp" %>
</head>
<body>
<%@ include file="../fragments/adminMenu.jsp"%>

	<div>
		<c:if test="${not empty message}">
${message}</c:if>
	</div>

	<div>
		<h1>Task options:</h1>
		<ul>
			<li><a href=<c:url value="task/add"></c:url>> Add new
					task</a></li>

		</ul>
	</div>
	<div>
		<h2>List of tasks:</h2>
		<ul>
			<c:forEach items="${tasks}" var="task">
				<li>${task.subject} <br>
				Project: ${task.project.name}
				<br>
				User: ${task.activeUser.surname}
				<br>
				Status: ${task.status.name}
				<br>
				Priority: ${task.priority.name}
				<br>
				Started: ${task.created}
				<br>
				<a href=<c:url value="/task/details/${task.id}"></c:url>>  <button type="button"> Show details </button></a>
				<a href=<c:url value="/task/edit/${task.id}"></c:url>>  <button type="button"> Edit </button></a>
				<a href=<c:url value="/task/changeStatus/${task.id}"></c:url>>  <button type="button"> Change status </button></a>
				</li>
			</c:forEach>
		</ul>
	</div>
	<%@ include file="../fragments/relBody.jsp" %>
</body>
</html>