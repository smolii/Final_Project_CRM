<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRM</title>
<%@ include file="fragments/relHead.jsp"%>
</head>
<body>
<link href="<c:url value="/resources/main.css" />" rel="stylesheet">

<c:if test="${not empty loggedUser}">
	<%@ include file="fragments/userMenu.jsp"%>

</c:if>
<c:if test="${empty loggedUser}">
<%@ include file="fragments/menu.jsp"%>
</c:if>

		<c:if test="${not empty message}"><div class="alert alert-info">
${message}</div></c:if>

<c:if test="${not empty projects}">
<div class="container confade mt-4 py-4">
		<div class="row">
				<div class="col">
		<h2>List of recent projects:</h2>
		<ul class="list-group">
		<c:forEach items="${projects}" var="proj">
			<li class="list-group-item">${proj.name} created: ${proj.niceDate}</li>
		</c:forEach>
		</ul>
		</div></div></div>
	</c:if>



	<c:if test="${not empty activities}">
	<div class="container confade mt-4 mb-5 py-4">
		<div class="row">
				<div class="col">
		<h2>List of recent activities:</h2>
		<ul class="list-group">
		<c:forEach items="${activities}" var="act" begin="0" end="25">
			<li class="list-group-item"><c:out value="${act.content}"></c:out></li>
		</c:forEach>
		</ul>
		</div></div></div>
	</c:if>
</div>
	<div class="col-1"></div>
		</div>
	</div>


	<%@ include file="fragments/relBody.jsp"%>
</body>
</html>