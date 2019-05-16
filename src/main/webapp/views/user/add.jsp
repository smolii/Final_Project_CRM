<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a new user here:</title>
<%@ include file="../fragments/relHead.jsp"%>
</head>
<body>
	<%@ include file="../fragments/menu.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-1"></div>

			<div class="col-10">

				<div class="container">
					<div class="row">
						<div class="col">
							<h2>Please register:</h2>
						</div>
					</div>
				</div>
				<c:if test="${not empty message}">
					<div class="alert alert-danger">${message}</div>
				</c:if>
				<div class="container confade mt-4 mb-5">
					<form:form action="register" method="post" modelAttribute="user">
						<div class="row">
							<div class="col form-group mt-4">
								<label>Insert Login</label>
								<form:input path="login" class="form-control" />
								<form:errors path="login" class="error" />
							</div>
						</div>
						<div class="row">
							<div class="col form-group">
								<label>Insert Password</label>
								<form:password path="password" class="form-control" />
								<form:errors path="password" class="error" />
							</div>
						</div>
						<div class="row">
							<div class="col form-group">
								<label>Insert Name</label>
								<form:input path="name" class="form-control" />
								<form:errors path="name" class="error"/>
							</div>
						</div>
						<div class="row">
							<div class="col form-group">
								<label>Insert Surname</label>
								<form:input path="surname" class="form-control" />
								<form:errors path="surname" class="error"/>
							</div>
						</div>
						<div class="row">
							<div class="col mb-4">
								<input type="submit" value="Add new user" class="btn btncol" />
							</div>
						</div>
					</form:form>
				</div>
			</div>

			<div class="col-10"></div>
		</div>
	</div>
	<%@ include file="../fragments/relBody.jsp"%>
</body>
</html>