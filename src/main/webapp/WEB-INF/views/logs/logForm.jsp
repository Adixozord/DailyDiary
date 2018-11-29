<%--
  Created by IntelliJ IDEA.
  User: aix
  Date: 2018-11-29
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>

<form:form modelAttribute="newLog" method="post" action="dd/logs/new">
    <form:textarea style="height:300px; width:360px" path="content"/><br>
    select category: <form:select path="category" items="${category}" itemLabel="name" itemValue="name"/><br>
    private <form:checkbox path="isPrivate" value="false"/><br>
    <input type="submit" value="Post!"/><br/>
</form:form>