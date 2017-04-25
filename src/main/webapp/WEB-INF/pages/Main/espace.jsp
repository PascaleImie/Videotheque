<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Espace utlisateurs</title>

    <%@ include file="head.jsp" %>
</head>
<body style="background-color:#000;" >
<header>
    <%@ include file="header.jsp" %>
</header>
    <c:if test="${!empty User}">
        <p class="success">Hello ${User.prenom}, contente de te revoir</p>
    </c:if>

<p class="bienvenue">BIENVENUE SUR L'APPLICATION VIDEOBOX</p>
<footer>
    <%@ include file="footer.jsp" %>
</footer>
</body>
</html>





