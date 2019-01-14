<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <c:forEach items="${users}" var="user">
        <li>
                ${user.name} ${user.surname} ${user.login}
            <a href="/user/edit/${user.id}">Edit user</a>
            <a href="/user/deleteConfirm/${user.id}">Delete user </a>
        </li>
    </c:forEach>

</ul>
<p><a href="${pageContext.request.contextPath}/admin/">Return</a></p>
</body>
</html>
