<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VideoBox</title>

    <spring:url value="/resources/css/monstyle.css" var="mainCss"/>
    <link href="${mainCss}" rel="stylesheet"/>

    <spring:url value="/resources/css/bootstrap.min.css" var="bootCss"/>
    <link href="${bootCss}" rel="stylesheet"/>

    <spring:url value="/resources/js/jquery-3.1.1.min.js" var="bootjs"/>
    <script type="text/javascript" src="${bootjs}"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body style="background-color:#000;">
<div class="container">
    <img src="resources/img/videobox3.png" alt="My videoBOx">
    <div class="btn-accueil">
        <div id="btn-connex"><a href="connexion"><button type="button" class="btn btn-success btn-lg">Connexion</button></a></div>
    </div>
</div>
</body>
</html>