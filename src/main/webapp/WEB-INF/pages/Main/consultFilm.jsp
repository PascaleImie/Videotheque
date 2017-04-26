<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consultation films</title>
    <%@ include file="head.jsp" %>
</head>
<body style="background-color:#000;" >
<header>
    <%@ include file="header.jsp" %>
</header>

<h1 style="color:white">Liste Films</h1>
<div class="container">
    <div class="row">
        <div class="box clearfix">
            <h1>Consulter films</h1>

            <table class="table" id="bootstrap-table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Titre</th>
                    <th>Nationalité</th>
                    <th>Année de sortie</th>
                    <th>Durée</th>
                    <th>Genres</th>
                    <th>Réalisateur</th>
                    <th>Fiche film</th>
                    <th><span class="glyphicon glyphicon-trash" style="color:red"></span></th>
                </tr>
                </thead>
                <c:forEach var="Films" items="${Films}">
                <tbody>
                <tr>
                    <td>${Films.id_film}</td>
                    <td>${Films.titre}</td>
                    <td>${Films.nationalite}</td>
                    <td>${Films.annee}</td>
                    <td>${Films.duree}</td>
                    <td>
                        <c:forEach var="Genre" items="${Films.genres}">
                            ${Genre.libelle}
                        </c:forEach>
                    </td>
                    <td>${Films.realisateur.prenom} ${Films.realisateur.nom}</td>
                    <td><a href="consultOneFilm/${Films.id_film}"><i class="fa fa-film" aria-hidden="true" style="color:yellow"></i></a></td>
                    <td><a href="deleteFilm/${Films.id_film}"><span class="glyphicon glyphicon-trash" style="color:red"></span></a></td>
                </tr>
                </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</div>
</body>
</html>