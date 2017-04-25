<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connexion</title>

    <spring:url value="/resources/css/style.css" var="mainCss"/>
    <link href="${mainCss}" rel="stylesheet"/>

    <spring:url value="/resources/css/monstyle.css" var="mainCss"/>
    <link href="${mainCss}" rel="stylesheet"/>

    <spring:url value="/resources/css/bootstrap.min.css" var="bootCss"/>
    <link href="${bootCss}" rel="stylesheet"/>

    <spring:url value="/resources/js/jquery-3.1.1.min.js" var="jqueryJs"/>
    <script type="text/javascript" src="${jqueryJs}"></script>

    <spring:url value="/resources/css/font-awesome.min.css" var="fontCss"/>
    <link href="${bootCss}" rel="stylesheet"/>

    <spring:url value="/resources/css/font-awesome.min.css" var="fontCss"/>
    <link href="${fontCss}" rel="stylesheet"/>

    <spring:url value="/resources/css/jquery.bdt.css" var="jqueryBdtCss"/>
    <script type="text/javascript" src="${jqueryBdtCss}"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <spring:url value="/resources/js/style.js" var="stylejs"/>
    <script type="text/javascript" src="${stylejs}"></script>


    <spring:url value="/resources/js/jquery.sortelements.js" var="sortEltJs"/>
    <script type="text/javascript" src="${sortEltJs}"></script>

    <spring:url value="/resources/js/jquery.bdt.min.js" var="bdtJs"/>
    <script type="text/javascript" src="${bdtJs}"></script>





</head>


</html>





