<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Daily Diary sign-up</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>
</head>
<body>

<div class="row">
    <div class="col-md-6 offset-md-3 text-center">
        <h1>Sign-up form</h1>
        <form:form modelAttribute="loginFormData">
            <div class="form-group row">
                <div class="col-md-12">
                    <form:input path="username" placeholder="Enter your login"/><form:errors path="username"/>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-md-12">
                    <form:input path="password" placeholder="Enter your password" type="password"/><form:errors path="password"/>
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
