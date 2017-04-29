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

    <spring:url value="/resources/css/jquery-ui.min.css" var="jqueryUiCss"/>
    <link href="${jqueryUiCss}" rel="stylesheet"/>


    <spring:url value="/resources/js/jquery-3.1.1.min.js" var="jqueryJs"/>
    <script type="text/javascript" src="${jqueryJs}"></script>

    <spring:url value="/resources/js/bootstrap.min.js" var="bootJs"/>
    <script type="text/javascript" src="${bootJs}"></script>


    <spring:url value="/resources/css/jquery-ui.structure.min.css" var="strucCss"/>
    <script type="text/javascript" src="${strucCss}"></script>

    <spring:url value="/resources/css/jquery-ui.theme.min.css" var="themeCss"/>
    <script type="text/javascript" src="${themeCss}"></script>


    <spring:url value="/resources/css/font-awesome.min.css" var="fontCss"/>
    <link href="${fontCss}" rel="stylesheet"/>

    <spring:url value="/resources/css/jquery.bdt.css" var="jqueryBdtCss"/>
    <script type="text/javascript" src="${jqueryBdtCss}"></script>

    <spring:url value="/resources/js/jquery-ui.min.js" var="uiJs"/>
    <script type="text/javascript" src="${uiJs}"></script>

    <spring:url value="/resources/js/style.js" var="stylejs"/>
    <script type="text/javascript" src="${stylejs}"></script>


    <spring:url value="/resources/js/jquery.sortelements.js" var="sortEltJs"/>
    <script type="text/javascript" src="${sortEltJs}"></script>

    <spring:url value="/resources/js/jquery.bdt.min.js" var="bdtJs"/>
    <script type="text/javascript" src="${bdtJs}"></script>








</head>


</html>





