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
</head>
<body>
<h3>We've sent you a confirmation email at adress ${registrationFormData.email}</h3>
<h3>Activate your account by entering your activation code below</h3>
<input type="submit" value="confirm">
<!-- automatic email sending to user, upon activation change enabled = true, enables to sign up-->
<a href="/dd">Go back to homepage</a>
</body>
</html>
