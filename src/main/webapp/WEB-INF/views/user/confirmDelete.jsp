<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@	taglib	prefix="form"
                 uri="http://www.springframework.org/tags/form"	%>
<html>
<head>
    <title>Title</title>
</head>
<body>

Potwierdz usuniecie użytkownika o id ${id}
<a href="/user/delete/${id}">POTWIERDŹ </a>
<a href="/user"> ANULUJ</a>
</body>
</html>
