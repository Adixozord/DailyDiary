<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Daily Diary sign-up</title>
    <c:import url="../bootstrap.jsp"></c:import>
</head>
<body>

<div class="row">
    <div class="col-md-6 offset-md-3">
        <h1>Sign-up form</h1>
        <form:form modelAttribute="loginFormData">
            <div class="form-group row">
                <div class="col-md-12">
                    <form:input style="width: 300px" path="username" placeholder="Enter your login"/><form:errors path="username"/>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-md-12">
                    <form:input style="width: 300px" path="password" placeholder="Enter your password" type="password"/><form:errors path="password"/>
                </div>
            </div>
            <div class="col-md-12">
                <button type="submit" class="btn btn-primary">Sign in</button>
            </div>
        </form:form>
        <a href="register">no account yet? You can register here!</a>
    </div>
</div>


</body>
</html>
