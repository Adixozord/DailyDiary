<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Daily Diary</title>
</head>
<body>
<h1> welcome to daily diary</h1>
<c:if test="${loggedUser != null}">
    <p>Logged in as: ${loggedUser.username}</p>
</c:if>
<div>
    <c:if test="${loggedUser == null}">
        <a href="signup">Log in here!</a><br>
        <a href="register">No account yet? register!</a><br>
    </c:if>

    <c:if test="${loggedUser != null}">
        <p> Personalised logs gonna show here</p>
    </c:if>

</div>
</body>
</html>
