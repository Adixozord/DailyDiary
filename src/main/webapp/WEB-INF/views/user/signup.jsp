<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Daily Diary sign-up</title>
</head>
<body>
<h1>Sign-up form</h1>
<form:form modelAttribute="loginFormData">
    <br>
    <form:input path="username" placeholder="Enter your login"/><form:errors path="username"/> <br>
    <form:input path="password" placeholder="Enter your password" type="password"/><form:errors path="password"/><br>

    <input type="submit" value="login"/>
</form:form>

<a href="register">no account yet? You can register here!</a>

</body>
</html>
