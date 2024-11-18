<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add a new Machine</title>
</head>
<body>
<form:form action="/addMachine?arcade=${arcadeId}" modelAttribute="machine" method="POST">
    Tagline:
    <form:input path="tagline"/>
    <form:errors path="tagline"/><br/>

    Supplier:
    <form:input path="supplier"/>
    <form:errors path="supplier"/><br/>

    Genre:
    <form:input path="genre"/>
    <form:errors path="genre"/><br/>

    Score:
    <form:input path="score"/>
    <form:errors path="score"/><br/>

    <input type="submit"/><form:errors/>
</form:form>
</body>
</html>