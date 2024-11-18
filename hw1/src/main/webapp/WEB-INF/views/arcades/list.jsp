<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of Arcades</title>
</head>
<body>
<c:forEach items="${arcades}" var="arcade">
    <p>Name: ${arcade.name}, Website:  ${arcade.website}, <a href="/machines?arcade=${arcade.id}">Machines</a></p>
</c:forEach>
</body>
</html>