<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Details for task</title>
<%@ include file="../fragments/relHead.jsp" %>
</head>
<body>
<%@ include file="../fragments/userMenu.jsp" %>

<h1>This is information page about task: ${task.subject}</h1>

Task creation date: ${task.created}
<br>
Project: ${task.project.name}
<br>
Task description:
<br>
${task.description}
<br>
Task priority: ${task.priority.name}
<br>
Task status: ${task.status.name}
<br>
User assigned to the task: ${task.activeUser.name} ${task.activeUser.surname}
<br>


	<%@ include file="../fragments/relBody.jsp" %>
</body>
</html>