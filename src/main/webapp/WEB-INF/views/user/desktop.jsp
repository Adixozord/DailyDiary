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
    <c:import url="../bootstrap.jsp"></c:import>

    <title>User desktop</title>

</head>
<body>
<h1 class="text-dark" align="center">User desktop</h1>
<c:if test="${userLogs.size() > 0}">
<h1>My logs</h1>
<c:forEach items="${userLogs}" var="log">
    <div class="card text-center">
        <div class="card-body">
            <h5 class="card-title">
                <td>
                    ${log.category}</h5>
            <p class="card-text">${log.content}</p>
        </div>
        <div class="card-footer text-muted">
            <c:if test="${log.isPrivate == true}">
                <p>private</p>
            </c:if>
            <p>${log.created}</p>
        </div>

    </div>
</c:forEach>
</c:if>
<c:if test="${userLogs.size() == 0}">
    <p>No logs yet</p>
</c:if>


<a class="text-dark" href="/dd"><i class="fas fa-arrow-left"></i>homepage</a>
</body>
</html>
