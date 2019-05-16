<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log in</title>
<%@ include file="../fragments/relHead.jsp" %>
</head>
<body>
<%@ include file="../fragments/menu.jsp" %>

<div class="container">
		<div class="row">
			<div class="col-1"></div>
			
			<div class="col-10">

				<div class="container">
					<div class="row">
						<div class="col">
		<c:if test="${not empty message}">
${message}</c:if>
						</div>
					</div>
		<div class="row">
				<div class="col">
	<h1>Please put Your username and password:</h1>
				</div>
		</div>
	</div>
		
		<form method="post">
	<div class="container confade mt-4 mb-5">
			<div class="row">
				<div class="col form-group mt-4">
	<label for="Username:">Username</label>
	<input type="text" name="username" class="form-control">
				</div>
			</div>
	
		<div class="row">
				<div class="col form-group">
				<label for="Password:">Password</label>
	<input type="password" name="password" class="form-control">
				</div>
		</div>
			<div class="row">
				<div class="col mb-4">
					<input type="submit" value="Log in" class="btn btncol"/>
				</div>
			</div>
		</div>
		</form>
	</div>
	<div class="col-10"></div>
		</div>
	</div>


	<%@ include file="../fragments/relBody.jsp"%>
</body>
</html>