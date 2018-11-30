<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Daily Diary</title>
    <c:import url="bootstrap.jsp"></c:import>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <nav class="navbar navbar-expand-lg  bg-info shadow p-3 mb-5 rounded">
                <div class="col-md-2">
                    <c:if test="${loggedUser != null}">
                        <p>Logged in as: ${loggedUser.username}</p>
                    </c:if>
                    <i class="fas fa-book-alt"></i>
                </div>
                <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                    <form class="form-inline my-2" method="get" action="#">
                        <input class="form-control mr-sm-2" type="search" name="search" placeholder="search"
                               aria-label="Search" style="width: 500px">
                    </form>

                </div>
                <c:if test="${loggedUser == null}">
                    <div class="collapse navbar-collapse text-center d-flex justify-content-end"
                         id="navbarTogglerDemo02">
                        <form class="form-inline">
                            <div class="col-md-4">
                                <a class="text-dark" href="signup"> <i class="fas fa-user fa-2x"></i><br>Log in
                                    here!</a>
                            </div>
                            <div class="col-md-6">

                                <a class="text-dark" href="register"><i class="fas fa-user-plus fa-2x"></i><br> Register
                                    here!</a><br>
                            </div>
                        </form>
                    </div>
                </c:if>

                <c:if test="${loggedUser != null}">
                <div class="col-md-4" align="right">
                    <a class="text-dark" href="/dd/user/${loggedUser.id}/desktop"><i class="fas fa-user-circle fa-2x"></i> Desktop</a><br>
                </div>
                <div class="col-md-6">
                    <form style="display: inline" method="get" action="/logout" class="form-inline">
                        <i class="fas fa-user-times fa-2x"></i>
                        <input class="btn btn-light" type="submit" value="Logout"/><br>
                    </form>
                </div>
                </c:if>
            </nav>
        </div>
    </div>
    <div class="main">
        <div class="row">
            <div class="col-md-3">
                <c:if test="${loggedUser != null}">
                    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseAdd"
                            aria-expanded="false" aria-controls="collapseAdd">
                        Add new log
                    </button>
                    <div class="collapse" id="collapseAdd">
                        <c:import url="logs/logForm.jsp"></c:import>
                    </div>
                </c:if>
            </div>
            <div class="col-md-9">
                <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample"
                        aria-expanded="false" aria-controls="collapseExample">
                    Show all logs
                </button>
                <div class="collapse show" id="collapseExample">
                    <c:forEach items="${allLogs}" var="log">
                        <c:if test="${log.isPrivate != true}">
                            <div class="card text-center">
                                <div style="text-align: left" class="card-header">
                                    <p>Author : ${log.user.username}</p>
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
</div>

</body>
</html>
