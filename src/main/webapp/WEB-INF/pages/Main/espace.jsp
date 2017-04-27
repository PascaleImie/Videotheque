<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VidedoBox</title>
    <%@ include file="head.jsp" %>
</head>
<header>
    <%@ include file="header.jsp" %>
</header>
<c:if test="${!empty User}">
    <p class="success">Hello ${User.prenom}, content(e) de te revoir</p>
</c:if>

<p class="bienvenue">BIENVENUE SUR L'APPLICATION VIDEOBOX</p>
</body>
</html>





