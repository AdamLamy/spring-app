<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of Arcades</title>
</head>
<body>
<c:forEach items="${machines}" var="machine">
    <p>Tagline: ${machine.tagline}, Supplier:  ${machine.supplier}, Genre:  ${machine.genre}, Score:  ${machine.score}</p>
</c:forEach>

<br><a href="/newMachine?arcade=${arcadeId}">New Machine</a>
</body>
</html>