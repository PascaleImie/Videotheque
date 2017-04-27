<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:form="http://www.w3.org/1999/html">
<head>
    <title>VideoBox</title>
    <%@ include file="head.jsp" %>
</head>
<body>
<header>
    <%@ include file="header.jsp" %>
</header>
<c:if test="${empty form.erreurs && !empty form}">
    <p>
        <c:out value="Inscription valide !"/>
    </p>
</c:if>
<form:form method="POST" modelAttribute="FilmRegister" action="/Videotheque/addFilm" >
    <div class="container">
        <p class="success">Admin : ${User.prenom}</p>
        <h1> Film <br/>
            <small>Renseigner les informations du film</small>
        </h1>
    </div>
    <div class="erreur">${Erreur}</div>
    <div class="container">
        <div class="form">
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="titre">Titre </label>
                        <td><form:input type="text" id="titre" class="form-control" path="titre"/></td>
                        <td><form:errors path="titre" cssClass="error"/></td>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="annee">Année de sortie </label>
                        <td><form:input type="number" min="1970" max="2017" id="annee" class="form-control" path="annee"/></td>
                        <td><form:errors path="annee" cssClass="error"/></td>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="duree">Duree </label>
                        <td><form:input type="text" id="duree" class="form-control" path="duree" placeholder="ex:1h59"/></td>
                        <td><form:errors path="duree" cssClass="error"/></td>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="nationalite">Nationalité </label>
                        <td><form:input type="text" id="nationalite" class="form-control" path="nationalite"/></td>
                        <td><form:errors path="nationalite" cssClass="error"/></td>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="genres">Genre </label>
                        <td>
                            <form:select id="genres" class="form-control" path="genres" multiple="true">
                                <form:options items="${Genres}"/>
                            </form:select>
                        </td>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="titre">Acteurs principaux</label>
                <div class="row">
                    <div class="col-md-6">
                        <form:input type="text" class="form-control" path="acteurs[0].prenom" placeholder="Prenom acteur 1" required="required"/>
                    </div>
                    <div class="col-md-6">
                        <form:input type="text" class="form-control" path="acteurs[0].nom" placeholder="NOM acteur 1" required="required"/>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-md-6">
                        <form:input type="text" class="form-control" path="acteurs[1].prenom" placeholder="Prenom acteur 2" required="required"/>
                    </div>
                    <div class="col-md-6">
                        <form:input type="text" class="form-control" path="acteurs[1].nom"  placeholder="NOM acteur 2" required="required"/>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-md-6">
                        <form:input type="text" class="form-control" path="acteurs[2].prenom" placeholder="Prenom acteur 3" required="required"/>
                    </div>
                    <div class="col-md-6">
                        <form:input type="text" class="form-control" path="acteurs[2].nom" placeholder="NOM acteur 3" required="required"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="titre">Réalisateur</label>
                <div class="row">
                    <div class="col-md-6">
                        <form:input type="text" class="form-control" id="prenom" path="realisateur.prenom" placeholder="Prenom"/>
                    </div>
                    <div class="col-md-6">
                        <form:input type="text" class="form-control" id="nom" path="realisateur.nom" placeholder="NOM"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="synopsis">Synopsis </label>
                        <td><form:textarea type="text" rows="10" col="10" id="synopsis" class="form-control" path="synopsis"/></td>
                        <td><form:errors path="synopsis" cssClass="error"/></td>
                    </div>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-md-offset-5 col-md-2 col-md-offset-5">
                    <button type="submit" id="button" class="btn btn-success btn-lg">Ajouter</button>
                </div>
            </div>
        </div>
    </div>
</form:form>
</body>
</html>





