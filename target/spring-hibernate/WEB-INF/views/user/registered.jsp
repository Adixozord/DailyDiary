<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aix
  Date: 2018-11-22
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success!</title>
    <c:import url="../bootstrap.jsp"></c:import>
</head>
<body>
<h3 class="text-dark">Successfuly registered with email adress : ${registrationFormData.email}</h3>
<i class="fas fa-arrow-left"></i><a href="/dd">Go back to homepage</a>
</body>
</html>
