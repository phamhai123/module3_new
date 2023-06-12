<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/24/2023
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Create Employee</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown" >
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Employee
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/Employees">Show list</a></li>
                        <li><a class="dropdown-item" href="#">Create</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown" >
                    <a class="nav-link dropdown-toggle" href="#" id="navbar" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Customer
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbar">
                        <li><a class="dropdown-item" href="#">Show list</a></li>
                        <li><a class="dropdown-item" href="#">Create</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="container">
    <form action="/Employees" method="post">
        <input type="hidden" name="action" value="create">
        <div class="mb-3">
            <label for="name">Name:</label>
            <input type="text" class="form-control" name="name" id="name" aria-describedby="helpId">
            <c:if test="${not empty errorName}">
                <div class="alert alert-warning" role="alert">
                    <small><c:out value="${errorName}"></c:out></small>
                </div>
                <c:set var="errorName" value="" scope="session"></c:set>
            </c:if>
        </div>
         <div class="row">
             <div class="mb-3 col-sm-6">
                 <label for="birthday">Birthday:</label>
                 <input type="date" class="form-control" name="birthday" id="birthday" aria-describedby="helpId">
                 <c:if test="${not empty errorDate}">
                     <div class="alert alert-warning" role="alert">
                         <small><c:out value="${errorDate}"></c:out></small>
                     </div>
                     <c:set var="errorDate" value="" scope="session"></c:set>
                 </c:if>
             </div>
             <div class="mb-3 col-sm-6">
                 <label for="idcard">id Card:</label>
                 <input type="text" class="form-control" name="idcard" id="idcard" aria-describedby="helpId">
                 <c:if test="${not empty errorIdCard}">
                     <div class="alert alert-warning" role="alert">
                         <small><c:out value="${errorIdCard}"></c:out></small>
                     </div>
                     <c:set var="errorIdCard" value="" scope="session"></c:set>
                 </c:if>
             </div>
             <div class="mb-3 col-sm-6">
                 <label for="salary">Salary:</label>
                 <input type="text" class="form-control" name="salary" id="salary" aria-describedby="helpId">
                 <c:if test="${not empty errorSalary}">
                     <div class="alert alert-warning" role="alert">
                         <small><c:out value="${errorSalary}"></c:out></small>
                     </div>
                     <c:set var="errorSalary" value="" scope="session"></c:set>
                 </c:if>
             </div>
             <div class="mb-3 col-sm-6">
                 <label for="phone">Phone:</label>
                 <input type="text" class="form-control" name="phone" id="phone" aria-describedby="helpId">
                 <c:if test="${not empty errorPhone}">
                     <div class="alert alert-warning" role="alert">
                         <small><c:out value="${errorPhone}"></c:out></small>
                     </div>
                     <c:set var="errorPhone" value="" scope="session"></c:set>
                 </c:if>
             </div>
             <div class="mb-3 col-sm-6">
                 <label for="email">Email:</label>
                 <input type="text" class="form-control" name="email" id="email" aria-describedby="helpId">
                 <c:if test="${not empty errorEmail}">
                     <div class="alert alert-warning" role="alert">
                         <small><c:out value="${errorEmail}"></c:out></small>
                     </div>
                     <c:set var="errorEmail" value="" scope="session"></c:set>
                 </c:if>
             </div>
             <div class="mb-3 col-sm-6">
                 <label for="address">Address:</label>
                 <input type="text" class="form-control" name="address" id="address" aria-describedby="helpId">
<%--                 <c:if test="${not empty errorAddress}">--%>
<%--                     <div class="alert alert-warning" role="alert">--%>
<%--                         <small><c:out value="${errorAddress}"></c:out></small>--%>
<%--                     </div>--%>
<%--                 </c:if>--%>
             </div>
         </div>

        <div class="row mb-3">
            <div class="col-sm-4">
                <label for="position">Position:</label>
                <%--            <input type="text" class="form-control" name="position" id="position" aria-describedby="helpId">--%>
                <select class="form-select" name="position" id="position">
                    <c:forEach items="${positions}" var="position">
                        <option value="${position.id}">${position.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-sm-4">
                <label for="education">Education:</label>
                <%--            <input type="text" class="form-control" name="education" id="education" aria-describedby="helpId">--%>
                <select class="form-select" name="education" id="education">
                    <c:forEach items="${educations}" var="education">
                        <option value="${education.id}">${education.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-sm-4">
                <label for="division">Division:</label>
                <%--            <input type="text" class="form-control" name="division" id="division" aria-describedby="helpId">--%>
                <select class="form-select" name="division" id="division">
                    <c:forEach items="${divisions}" var="division">
                        <option value="${division.id}">${division.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <button type="submit" class="btn btn-success">Create</button>
        <a class="btn btn-primary" href="/Employees" role="button">Back to menu</a>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
