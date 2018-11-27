<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Daily diary register</title>
</head>
<body>
<h1>Registration form</h1>
<form:form modelAttribute="registrationFormData">
    <br>
   <form:input path="username" placeholder="Enter your login"/><form:errors path="username"/> <br>
   <form:input path="email" placeholder="Enter your e-mail address" type="email"/><form:errors path="email"/> <br>

   <form:input path="password" placeholder="Enter your password" type="password"/><form:errors path="password"/><br>
    <form:input path="confirmedPassword" placeholder="Re-enter your password" type="password"/><form:errors path="confirmedPassword"/><br>
    <!-- check if both fields contain same value-->

    <input type="submit" value="register"/>
</form:form>
<a href="signup">i already have an account</a>


</body>
</html>
