<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Daily Diary</title>
</head>
<input>
<h1> welcome to daily diary</h1>
<c:if test="${loggedUser != null}">
    <p>Logged in as: ${loggedUser.username}</p><form action="${pageContext.request.contextPath}/log-out" method="get">
    <input type="submit" value="Logout" />
    <a href="/dd/user/${loggedUser.id}/desktop">Desktop</a><br>
    <a href="/dd/logs/new">Add new log</a>
</c:if>
<c:if test="${loggedUser == null}">
    <div>
        <a href="signup">Log in here!</a><br>
        <a href="register">No account yet? register!</a><br>
    </div>
</c:if>
<p> All logs </p>
<tbody>
<c:forEach items="${allLogs}" var="log">
    <c:if test="${log.isPrivate != true}">
        <tr>
            <br>
            <td>Category: ${log.category}</td>
            <br>
            <td>${log.content}</td>
            <br>
        </tr>
    </c:if>
</c:forEach>
</tbody>
</form>
</body>
</html>
