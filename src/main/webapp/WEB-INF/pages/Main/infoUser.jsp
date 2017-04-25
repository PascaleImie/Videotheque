<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="head.jsp" %>
</head>

<body style="background-color:#000;" >
<header>
    <%@ include file="header.jsp" %>
</header>
<div class="container">
    <h1> Mes infos utilisateur</h1>
</div>

<div class="container">
    <div class="form">
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label for="nom">Nom </label>
                    <td><input type="text" id="nom" class="form-control" value="${User.nom}" readonly="readonly"/></td>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label for="nom">Prénom </label>
                    <td><input type="text" id="prenom" class="form-control" value="${User.prenom}" readonly="readonly"/></td>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label for="nom">Email</label>
                    <td><input type="text" id="email" class="form-control" value="${User.email}" readonly="readonly"/></td>
                </div>
            </div>
        </div>
    </div>
</div>
<footer>

</footer>
</body>
</html>





