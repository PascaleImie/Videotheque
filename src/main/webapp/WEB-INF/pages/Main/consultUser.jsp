<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <meta charset="UTF-8">
    <title>Consultation utilisateurs</title>
    <%@ include file="head.jsp" %>
</head>
<body style="background-color:#000;" >
<header>
    <%@ include file="header.jsp" %>
</header>

<!--<h1 style="color:white">Liste utilisateurs</h1>-->
<h1>Liste utilisateurs</h1>
<div class="container">
<table class="table table-sm">

    <thead>
    <tr>
        <th>#</th>
        <th>NOM</th>
        <th>PRENOM</th>
        <th>ROLE</th>
        <th>EMAIL</th>
        <th></th>

    </tr>
    </thead>
    <c:forEach var="listUser" items="${listUser}">
    <tbody>
    <tr>
        <th scope="row">${listUser.id}</th>
        <td>${listUser.nom}</td>
        <td>${listUser.prenom}</td>
        <td>${listUser.role}</td>
        <td>${listUser.email}</td>
        <td><a href="deleteUser/${listUser.id}"><span class="glyphicon glyphicon-trash" style="color:black"></span></a></td>
    </tr>
    </tbody>
    </c:forEach>
</table>
</div>
</body>
</html>