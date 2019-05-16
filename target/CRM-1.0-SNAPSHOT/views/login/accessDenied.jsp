<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Access denied!</title>
<%@ include file="../fragments/relHead.jsp" %>
</head>
<body>
<%@ include file="../fragments/menu.jsp" %>
Sorry, You do not have permission to access this page.
Please log in: <a href= <c:url value="/login"></c:url>> Click here to log in </a>
<br>

or register: <a href=<c:url value="/register"></c:url>> Click here to register</a>
<%@ include file="../fragments/relBody.jsp" %>
</body>
</html>