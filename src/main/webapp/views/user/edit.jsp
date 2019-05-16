<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit</title>
<%@ include file="../fragments/relHead.jsp" %>
</head>
<body>
<%@ include file="../fragments/userMenu.jsp" %>

<div class="container">
		<div class="row">
			<div class="col-1"></div>
			
			<div class="col-10">

		<div class="row">
				<div class="col">
					<h1>Edit user:</h1>
				</div>
		</div>
		
		<form:form method="post" modelAttribute="user">
	<div class="container confade mt-4 mb-5">
			<div class="row">
				<div class="col form-group mt-4">
	<label for="Login:">Login:</label>
	<form:input path="login" value="${user.login}" class="form-control" />
				</div>
			</div>
	<div class="row">
	<div class="col form-group">
	<label for="Name">Name:</label>
<form:input path="name" value="${user.name}" class="form-control" />
				</div>
			</div>
			<div class="row">
			<div class="col form-group">
	<label for="Surname:">Surname:</label>
	<form:input path="surname" value="${user.surname}" class="form-control" />
				</div>
			</div>
		
			<div class="row">
				<div class="col mb-4">
					<input type="submit" value="Save changes" class="btn btncol"/>
				</div>
			</div>
		</div>
		</form:form>
	</div>
	<div class="col-10"></div>
		</div>
	</div>


	<%@ include file="../fragments/relBody.jsp"%>
</body>
</html>