<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Daily Diary</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="col-md-4">
                    <i class="fas fa-book-alt"></i>
                </div>
                <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                    <form class="form-inline my-2" method="get" action="#">
                        <input class="form-control mr-sm-2" type="search" name="search" placeholder="search"
                               aria-label="Search"><span><i class="fas fa-search"></i></span>
                    </form>

                </div>
                <c:if test="${loggedUser == null}">
                    <div class="collapse navbar-collapse text-center" id="navbarTogglerDemo02">
                        <form class="form-inline">
                            <div class="col-md-6">
                                <i class="fas fa-user"></i><br>
                                <a href="signup">Log in here!</a>
                            </div>
                            <div class="col-md-6">
                                <a href="register">No account yet? register!</a><br>
                            </div>
                        </form>
                    </div>
                </c:if>
                <c:if test="${loggedUser != null}">
                    <form method="get" action="/logout" class="form-inline">
                        <input type="submit" value="Logout1"/>
                        <p>Logged in as: ${loggedUser.username}</p>
                        <a href="/dd/user/${loggedUser.id}/desktop">Desktop</a><br>
                    </form>
                </c:if>
            </nav>
        </div>
    </div>
    <div class="main">
        <div class="row">
            <div class="col-md-3">
                <c:if test="${loggedUser != null}">
                    <h3> Add new log </h3>
                    <c:import url="logs/logForm.jsp"></c:import>
                </c:if>
            </div>
            <div class="col-md-9">
                <h3>All logs</h3>
                <c:forEach items="${allLogs}" var="log">
                    <c:if test="${log.isPrivate != true}">
                        <div class="card text-center">
                            <div class="card-header">
                                <p>${log.user.username}</p>
                            </div>
                            <div class="card-body">
                                <h5 class="card-title">
                                    <td>
                                        ${log.category}</h5>
                                <p class="card-text">${log.content}</p>
                            </div>
                            <div class="card-footer text-muted">
                                <p>${log.created}</p>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>

        </div>
    </div>
</div>
</div>

</body>
</html>
