<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: aix
  Date: 2018-11-27
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User desktop</title>
</head>
<body>
<h1> my logs</h1>
<c:forEach items="${userLogs}" var="log">
    <tr>
        <br>
        <td>Category: ${log.category}</td>
        <br>
        <td>${log.content}</td>
        <br>
        <div>
           ${log.created}
        </div>
    </tr>
</c:forEach>
<h1> stats </h1>
<a href="/dd">homepage</a>
</body>
</html>
