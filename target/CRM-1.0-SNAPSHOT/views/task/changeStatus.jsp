<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change status</title>
<%@ include file="../fragments/relHead.jsp"%>
</head>
<body>
	<%@ include file="../fragments/userMenu.jsp"%>
	<h1>Change status</h1>
	<br>
	<div>
		<form method="post">
			Status: <select name="newStatus" size="3">
				<c:forEach items="${statuses}" var="sta">
				<option value="${sta.id}">${sta.name}</option>
				</c:forEach>
			</select>
			<div>
				<input type="submit" value="Set new status" />
			</div>
		</form>
	</div>
	<%@ include file="../fragments/relBody.jsp"%>
</body>
</html>