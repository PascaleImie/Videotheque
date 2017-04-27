<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<head>
    <title>VideoBox</title>

    <spring:url value="/resources/css/style.css" var="mainCss"/>
    <link href="${mainCss}" rel="stylesheet"/>

    <spring:url value="/resources/css/bootstrap.min.css" var="bootCss"/>
    <link href="${bootCss}" rel="stylesheet"/>

    <spring:url value="/resources/js/jquery-3.1.1.min.js" var="bootjs"/>
    <script type="text/javascript" src="${bootjs}"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <spring:url value="/resources/js/style.js" var="stylejs"/>
    <script type="text/javascript" src="${stylejs}"></script>
</head>
<body>
<header>
    <h1>My VideoBox</h1>
</header>
<div class="col-md-offset-3 col-md-6 col-md-offset-3">
    <form:form method="POST" modelAttribute="User" action="/Videotheque/connectUser">
        <div class="erreur">${Erreur}</div>
        <div class="form">
            <div class="row">
                <div class="col-md-offset-3 col-md-6 col-md-offset-3">
                    <div class="form-group">
                        <label for="email">Email </label>
                        <td><form:input type="email" id="emailConnect" class="form-control" path="email"/></td>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-offset-3 col-md-6 col-md-offset-3">
                    <div class="form-group">
                        <label for="mdp">Mot de passe </label>
                        <td><form:input type="password" id="mdpConnect" class="form-control"  path="mdp"/></td>
                    </div>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-md-offset-5 col-md-2 col-md-offset-5">
                    <button type="submit" id="buttonConnect" class="btn btn-success btn-lg">S'identifier</button>
                </div>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>





