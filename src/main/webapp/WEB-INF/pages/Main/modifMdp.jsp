<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VideoBox</title>
    <%@ include file="head.jsp" %>
</head>
<body>
<header>
    <%@ include file="header.jsp" %>
</header>
<c:if test="${!empty User}">
    <p class="success">Connecté: ${User.prenom}</p>
</c:if>
<div class="col-md-offset-3 col-md-6 col-md-offset-3">
    <form:form method="POST" modelAttribute="UserModif" action="/Videotheque/modifPass">
        <div class="container">
            <div class="alert alert-success" id="success"></div>
        </div>
        <div class="container">
            <div class="alert alert-danger" id="alert"></div>
        </div>
        <div class="form">
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="mdp">Ancien mot de passe</label>
                        <td><form:input type="password" id="mdpConnect" class="form-control" path="mdp"/></td>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="newMdp">Nouveau de mot de passe</label>
                        <td><input type="password" id="newMdp" class="form-control" name="newMdp"/></td>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="mdp">Confirmer nouveau mot de passe</label>
                        <td><input type="password" id="mdpConf" class="form-control" name="mdpConf"/></td>

                    </div>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-md-offset-5 col-md-2 col-md-offset-5">
                    <button type="submit" id="buttonModif" class="btn btn-success btn-lg">Modifier</button>
                </div>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>





