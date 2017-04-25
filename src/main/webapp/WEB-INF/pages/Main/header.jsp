<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body style="background-color:#000;" >
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#" style="color: #37e824;font-size: 28px;">My VideoBox</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/Videotheque/espace">Accueil</a></li>
            <c:if test="${User.role=='admin'}">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Gestion utilisateurs
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/Videotheque/inscription">Inscrire</a></li>
                        <li><a href="/Videotheque/consultUser">Consulter/Supprimer</a></li>
                    </ul>
                </li>
            </c:if>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Mon compte
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/Videotheque/infoUser">Mes infos</a></li>
                    <li><a href="/Videotheque/modifMdp">Modifier mot de passe</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Film
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/Videotheque/filmRegister">Ajouter film</a></li>
                    <li><a href="/Videotheque/consultFilm">Consulter film</a></li>
                    <!--<c:if test="${User.role=='admin'}">
                        <li><a href="#">Supprimer Film</a></li>
                    </c:if>-->
                </ul>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/Videotheque/connexion"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            <li><a href="/Videotheque/deconnexion"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
    </div>
</nav>

</body>
</html>





