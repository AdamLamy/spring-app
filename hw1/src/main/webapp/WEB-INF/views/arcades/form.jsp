<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add a new Arcade</title>
</head>
<body>
<form:form action="/addArcade" modelAttribute="arcade" method="POST">
    ID:
    <form:input path="id"/>
    <form:errors path="id"/><br/>

    Name:
    <form:input path="name"/>
    <form:errors path="name"/><br/>

    Website:
    <form:input path="website"/>
    <form:errors path="website"/><br/>

    <input type="submit"/><form:errors/>
</form:form>
</body>
</html>