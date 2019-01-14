
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@	taglib	prefix="form"
                 uri="http://www.springframework.org/tags/form"	%>

<html>
<head>
    <title>Add user</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
    <form:input path="name" placeholder="User's name"/>
    <form:errors path="name"/>
    <form:input path="surname" placeholder="User's surname"/>
    <form:errors path="surname"/>
    <form:input path="login" placeholder="login"/>
    <form:errors path="login"/>
    <form:password path="password" placeholder="password"/>
    <form:errors path="password"/>
    <form:select path="role.id"
                 items="${roles}"
                 itemValue="id"
                 itemLabel="role"/>
    <form:errors path="role"/>
    <input type="submit" value="Save"/>
</form:form>

</body>
</html>
