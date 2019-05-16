<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>This is Your profile</title>
<%@ include file="../fragments/relHead.jsp" %>
</head>
<body>
<%@ include file="../fragments/userMenu.jsp" %>
<div class="container">
		<div class="row">
			<div class="col-1"></div>
			
			<div class="col-10">
	<c:if test="${not empty message}"><div class="alert alert-warning">
${message}</div></c:if>

	<div class="row">
				<div class="col">
		<h1>Hello ${currentUser.name} ${currentUser.surname}</h1>
	</div>
	</div>
	
	<div class="row">
				<div class="col">
				<div class="list-group">
	<a class="list-group-item list-group-item-action" href=<c:url value="/task/add"></c:url>> Add new tasks </a>
	</div>
	</div>
	</div>
	
	
	<c:if test="${not empty myTasks}">
	<div class="container confade mt-4 py-4 mb-5">
		<div class="row">
				<div class="col">
	<h2>List of Your tasks:</h2>
	<table class="table table-striped">
  <thead>
    <tr>
      <th>Task:</th>
      <th>Project:</th>
      <th>Creation date:</th>
      <th>Status:</th>
      <th></th>
      <th>Priority:</th>
      <th></th>
      <th></th>
       </tr>
  </thead>
 		 <tbody>
	<c:forEach items="${myTasks}" var="task">
	<tr>
	<td>${task.subject}</td>
	<td>${task.project.name}</td>
	<td>${task.niceDate}</td>
	<td>${task.status.name} </td>
	<td><a href=<c:url value="/task/changeStatus/${task.id}"></c:url>> Change status </a></td>
	<td>${task.priority.name}</td> 
	<td><a href=<c:url value="/task/edit/${task.id}"></c:url>> Edit this task </a></td>
	<td><a href=<c:url value="/task/details/${task.id}"></c:url>> See task details </a></td>
	</tr>
	</c:forEach>
	</tbody>
		</table>
	</div>
	</div>
	</div>
	</c:if>
		</div>
	<div class="col-1"></div>
		</div>
	</div>


	<%@ include file="../fragments/relBody.jsp"%>
</body>
</html>