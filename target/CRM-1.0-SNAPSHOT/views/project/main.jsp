<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projects</title>
<%@ include file="../fragments/relHead.jsp" %>
</head>
<body>
<%@ include file="../fragments/adminMenu.jsp"%>

	<div>
		<c:if test="${not empty message}">
${message}</c:if>
	</div>

	<div>
		<h1>Projects options:</h1>
		<ul>
			<li><a href=<c:url value="/project/add"></c:url>> Add new
					project</a></li>

		</ul>
	</div>
	<div>
		<h2>List of projects:</h2>
		<ul>
			<c:forEach items="${projects}" var="project">
				<li>${project.name} <br>
				Website: ${project.websiteUrl}
				<br>
				Started: ${project.created}
				<a href=<c:url value="/project/details/${project.id}"></c:url>>  <button type="button"> Show details </button></a>
				<a href=<c:url value="/project/edit/${project.id}"></c:url>>  <button type="button"> Edit </button></a>
					<a href=<c:url value="/project/delete/${project.id}"></c:url>><button type="button"> Delete </button> </a>
				</li>
			</c:forEach>
		</ul>
	</div>
	<%@ include file="../fragments/relBody.jsp" %>
</body>
</html>