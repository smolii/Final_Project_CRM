
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Priorities</title>
<%@ include file="../fragments/relHead.jsp" %>
</head>
<body>
<%@ include file="../fragments/adminMenu.jsp"%>

	<div>
		<c:if test="${not empty message}">
${message}</c:if>
	</div>

	<div>
		<h1>Priority options:</h1>
		<ul>
			<li><a href=<c:url value="/priority/add"></c:url>> Add new
					priority</a></li>

		</ul>
	</div>
	<div>
		<h2>List of priorities:</h2>
		<ul>
			<c:forEach items="${priorities}" var="prior">
				<li>${prior.name}<a
					href=<c:url value="/priority/edit/${prior.id}"></c:url>>  <button type="button"> Edit </button></a>
					<a href=<c:url value="/priority/delete/${prior.id}"></c:url>>
						<button type="button"> Delete </button> </a>
				</li>
			</c:forEach>
		</ul>
	</div>
	<%@ include file="../fragments/relBody.jsp" %>
</body>
</html>