<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Statuses</title>
<%@ include file="../fragments/relHead.jsp" %>
</head>
<body>
<%@ include file="../fragments/adminMenu.jsp"%>

	<div>
		<c:if test="${not empty message}">
${message}</c:if>
	</div>

	<div>
		<h1>Statuses options:</h1>
		<ul>
			<li><a href=<c:url value="/status/add"></c:url>> Add new
					status</a></li>

		</ul>
	</div>
	<div>
		<h2>List of statuses:</h2>
		<ul>
			<c:forEach items="${statuses}" var="stat">
				<li>${stat.name} value: ${stat.sortType}
				<a
					href=<c:url value="/status/edit/${stat.id}"></c:url>>  <button type="button"> Edit </button></a>
					<a href=<c:url value="/status/delete/${stat.id}"></c:url>>
						<button type="button"> Delete </button> </a>
				</li>
			</c:forEach>
		</ul>
	</div>
	<%@ include file="../fragments/relBody.jsp" %>
</body>
</html>