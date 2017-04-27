<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>VideoBox</title>
    <%@ include file="head.jsp" %>
</head>
<body style="background-color:#000;" >
<header>
    <%@ include file="header.jsp" %>
</header>
<c:if test="${!empty User}">
    <p class="success">Connecté: ${User.prenom}</p>
</c:if>
<button type="button" class="btn btn-link btn-lg"><a href="/Videotheque/consultFilm">Revenir à la liste des films</a></button>
<div class="container">
    <div class="row" >
        <div id="titre">
            <h1>${Film.titre}</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 ">
            <p class="libelle">Année de sortie : ${Film.annee}</p>
        </div>
        <div class="col-md-6">
            <p class="libelleR">Durée : ${Film.duree}</p>

        </div>
    </div>
    <div class="row">
        <div class="col-md-6 ">
            <p class="libelle">Genre(s) :
                <c:forEach var="genre" items="${Genres}">
                    ${genre.libelle}
                </c:forEach></p>
        </div>
        <div class="col-md-6 ">
            <p class="libelleR">Nationalité : ${Film.nationalite}</p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 ">
            <p class="libelle">Acteurs principaux :
                <c:forEach var="acteur" items="${Acteurs}">
                    ${acteur.prenom} ${acteur.nom},
                </c:forEach></p>
        </div>
        <div class="col-md-6">
            <p class="libelleR">Réalisateur : ${Realisateur.prenom} ${Realisateur.nom}</p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 ">
            <p class="libelle"><br>
            <div class="libelle">
                ${Film.synopsis}
            </div>
            </p>
        </div>
    </div>
</div>
</body>
</html>