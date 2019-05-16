<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit task</title>
<%@ include file="../fragments/relHead.jsp" %>
</head>
<body>
<%@ include file="../fragments/userMenu.jsp" %>
	<h1>Edit task</h1>
	<br>
	<div>
		<form:form method="post" modelAttribute="myTask">
		<<div>
				Subject:
				<form:input path="subject" value="${myTask.subject }" />
			</div>
			<div>
				Description:
				<form:textarea path="description" rows="5" cols="30"
					placeholder="${myTask.description }" />
			</div>
			<div>
				Project:
				<form:select path="project.id">
					<form:options items="${projects}" itemLabel="name" itemValue="id" />
				</form:select>
			</div>
			<div>
				User:
				<form:select path="activeUser.id">
					<form:options items="${users}" itemLabel="surname" itemValue="id" />
				</form:select>
			</div>
			<div>
				Priority:
				<form:select path="priority.id">
					<form:options items="${priorities}" itemLabel="name" itemValue="id" />
				</form:select>
			</div>
			<div>
				Status:
				<form:select path="status.id">
					<form:options items="${statuses}" itemLabel="name" itemValue="id" />
				</form:select>
			</div>
			<div>
				<input type="submit" value="Save task" />
			</div>
		</form:form>
	</div>
	<%@ include file="../fragments/relBody.jsp" %>
</body>
</html>