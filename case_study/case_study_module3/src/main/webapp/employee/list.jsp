<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/24/2023
  Time: 11:14 AM
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
    <title>List Employee</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-info">
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
                        <li><a class="dropdown-item" href="#">Show list</a></li>
                        <li><a class="dropdown-item" href="/Employees?action=create">Create</a></li>
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
<div class="px-3">

    <table class="table table-hover table-inverse" id="tableEmployee">
        <thead class="thead-inverse">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Id Card</th>
            <th>Salary</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Position</th>
            <th>Education</th>
            <th>Division</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.birthday}</td>
                <td>${employee.idCard}</td>
                <td>${employee.salary}</td>
                <td>${employee.phone}</td>
                <td>${employee.email}</td>
                <td>${employee.address}</td>
                <td>
                        <%-- ${employee.position}--%>
                        <c:forEach items="${positions}" var="position">
                            <c:if test="${employee.position == position.id}">
                                ${position.name}
                            </c:if>
                        </c:forEach>    
                </td>
                <td>
                        <%-- ${employee.education}--%>
                            <c:forEach items="${educations}" var="education">
                                <c:if test="${employee.education == education.id}">
                                    ${education.name}
                                </c:if>
                            </c:forEach>
                </td>
                <td>
                        <%-- ${employee.division}--%>
                            <c:forEach items="${divisions}" var="division">
                                <c:if test="${employee.division == division.id}">
                                    ${division.name}
                                </c:if>
                            </c:forEach>
                </td>
                <td>
                    <a class="btn btn-success" href="/Employees?action=update&id=${employee.id}" role="button">Edit</a>
                </td>
                <td>
                    <button onclick="showModelDelete('${employee.id}','${employee.name}')"
                            type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modelId">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- Modal -->
    <div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="modelTitleId"></h4>
                    <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>Do you want to delete: <span id="employeeName" style="color: red"></span></p>
                </div>
                <form action="/Employees">
                    <div class="modal-footer">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="" id="employeeId">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>
<script>
    $(document).ready(function () {
        $('#tableEmployee').dataTable({
            'pageLength' : 4,
            'searching' : false
        })
    })
    function showModelDelete(id, name) {
        console.log(id, name);
        document.getElementById("employeeName").innerText = name;
        document.getElementById("employeeId").value = id;
    }
</script>
</body>
</html>
