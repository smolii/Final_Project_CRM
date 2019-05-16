<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit project</title>
<%@ include file="../fragments/relHead.jsp" %>
</head>
<body>
<%@ include file="../fragments/userMenu.jsp" %>
<h1>Edit project</h1>
<br>
<div>
<form:form method="post" modelAttribute="myProject">
		<div>
			Name:
			<form:input path="name" value="${myProject.name}" />
		</div>
		<div>
			Description:
			<form:textarea path="description" rows="5" cols="30" placeholder="${myProject.description}"/>
		</div>
		<div>
			Website url:
			<form:input path="websiteUrl" value="${myProject.websiteUrl}"/>
		</div>
		<div>
			<input type="submit" value="Edit project" />
		</div>
	</form:form>
</div>
<%@ include file="../fragments/relBody.jsp" %>
</body>
</html>