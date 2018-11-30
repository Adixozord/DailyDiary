<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Daily diary register</title>
    <c:import url="../bootstrap.jsp"></c:import>

</head>
<body>
<div class="row">
    <div class="col-md-6 offset-md-3">
        <h1>Registration form</h1>
        <form:form modelAttribute="registrationFormData">
            <div class="form-group row">
                <div class="col-md-12">
                    <form:input style="width: 300px" path="username" placeholder="Enter your login"/><form:errors path="username"/>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-md-12">
                    <form:input style="width: 300px" path="email" placeholder="Enter your e-mail address" type="email"/><form:errors
                        path="email"/>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-md-12">
                    <form:input style="width: 300px" path="password" placeholder="Enter your password" type="password"/><form:errors
                        path="password"/>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-md-12">
                    <form:input style="width: 300px" path="confirmedPassword" placeholder="Re-enter your password"
                                type="password"/><form:errors
                        path="confirmedPassword"/>
                </div>
            </div>
            <input type="submit" value="register"/>
        </form:form><br>
        <a href="signup">i already have an account</a>
    </div>
</div>


<!-- check if both fields contain same value-->


</body>
</html>
