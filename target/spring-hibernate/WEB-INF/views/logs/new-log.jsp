<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: aix
  Date: 2018-11-27
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new log</title>
</head>
<body>
<form:form modelAttribute="newLog" method="post">
    <form:input path="content" type="textarea" placeholder="Place your thoughts here"/>
    select category: <form:select path="category" items="${category}" itemLabel="name" itemValue="name"/><br>
    private <form:checkbox path="isPrivate" value="false"/>
    <input type="submit" value="Post!"/><br/>
</form:form>
</body>
</html>
