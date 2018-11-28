<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aix
  Date: 2018-11-28
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p> Personalised logs</p>
<tbody>
<c:forEach items="${userLogs}" var="log">
    <tr>
        <br>
        <td>Category: ${log.category}</td>
        <br>
        <td>${log.content}</td>
        <br>
        <td><a href="/logs/${log.id}/options">options</a> </td>
    </tr>
</c:forEach>
</tbody>
</body>
</html>
