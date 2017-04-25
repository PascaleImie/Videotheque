<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="head.jsp" %>
</head>

<body style="background-color:#000;" >
<header>
    <%@ include file="header.jsp" %>
</header>
<c:if test="${empty form.erreurs && !empty form}">
    <p>
        <c:out value="Inscription valide !"/>
    </p>
</c:if>

<form:form method="POST" modelAttribute="UserInscription" action="/Videotheque/addUser">

    <div class="container">
         <p class="success">Admin : ${User.prenom}</p>

        <h1> Inscription <br/>
            <small>Renseigner les informations utilisateur</small>
        </h1>
    </div>
    <div class="erreur">${Erreur}</div>
    <div class="container">
        <div class="alert alert-success" id="success"></div>
    </div>
    <div class="container">
        <div class="alert alert-danger" id="alert"></div>
    </div>
        <div class="container">
            <div class="form">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="nom">Nom </label>
                                <td><form:input type="text" id="nom" class="form-control" path="nom"/></td>
                                <td><form:errors path="nom" cssClass="error"/></td>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="prenom">Prénom </label>
                                <td><form:input type="text" id="prenom" class="form-control" path="prenom"/></td>
                                <td><form:errors path="prenom" cssClass="error"/></td>
                            </div>
                        </div>
                    </div>
              <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="role">Role</label>
                            <td>
                                <form:select id="role" class="form-control" path="role">
                                    <form:option value="admin">admin</form:option>
                                    <form:option value="user">user</form:option>
                                </form:select>
                            </td>
                        </div>
                    </div>
                </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="email">Email </label>
                                <td><form:input type="email" id="email" class="form-control" path="email"/></td>
                                <td><form:errors path="email" cssClass="error"/></td>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-offset-5 col-md-2 col-md-offset-5">
                            <button type="submit" id="button" class="btn btn-success btn-lg">Ajouter</button>
                        </div>
                    </div>
            </div>
        </div>
</form:form>
<footer>

</footer>
</body>
</html>





