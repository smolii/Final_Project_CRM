<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit status</title>
<%@ include file="../fragments/relHead.jsp" %>
</head>
<body>
<%@ include file="../fragments/menu.jsp" %>
<h2>Edit status:</h2>
<br>
<form:form  method="post" modelAttribute="status">
		<div>
			Name:
			<form:input path="name" value="${status.name}"/>
		</div>
		<div>
		Value:
		<form:input type="number" path="sortType" step="1" min="1" value="${status.sortType}" />
		</div>
		<div>
			<input type="submit" value="Submit" />
		</div>
	</form:form>
	<%@ include file="../fragments/relBody.jsp" %>
</body>
</html>