<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Welcome!</h1>
<h3>Join our growing Community</h3>
<div class="container w-50">
    <form:form action="/register" method="post" modelAttribute="newUser">

        <div class="row d-flex justify-content-center">
            <h2>Register: </h2>
        </div>

        <div class="row border border-info p-1">
            <div class="col border-end border-info">
                <form:label path="userName">Username: </form:label>
                <form:errors path="userName"></form:errors>
            </div>
            <div class="col w-100">
                <form:input path="userName"></form:input>
            </div>
        </div>

        <div class="row border border-info p-1">
            <div class="col border-end border-info">
                <form:label path="email">Email: </form:label>
                <form:errors path="email"></form:errors>
            </div>
            <div class="col w-100">
                <form:input path="email"></form:input>
            </div>
        </div>

        <div class="row border border-info p-1">
            <div class="col border-end border-info">
                <form:label path="password">Password: </form:label>
                <form:errors path="password"></form:errors>
            </div>
            <div class="col w-100">
                <form:input type="password" path="password"></form:input>
            </div>
        </div>

        <div class="row border border-info p-1">
            <div class="col border-end border-info">
                <form:label path="confirm">Confirm Password: </form:label>
                <form:errors path="confirm"></form:errors>
            </div>
            <div class="col w-100">
                <form:input type="password" path="confirm"></form:input>
            </div>
        </div>

        <div class="row border border-info p-1">
            <input type="submit" value="Register">
        </div>
    </form:form>

</div>
<div class="container w-50">
    <form action="/login" method="post">

        <div class="row d-flex justify-content-center">
            <h2>Login: </h2>
        </div>


        <div class="row border border-info p-1">
            <div class="col border-end border-info">
                <label for="email">Email: </label>
            </div>
            <div class="col w-100">
                <input type="email" id="email" name="email"/>
            </div>
        </div>

        <div class="row border border-info p-1">
            <div class="col border-end border-info">
                <label for="password">Password: </label>
            </div>
            <div class="col w-100">
                <input type="password" id="password" name="password"/>
            </div>
        </div>

        <div class="row border border-info p-1">
            <input type="hidden" name="${_csfr.paramaterName}" value="${_csfr.token}">
            <input type="submit" value="Login!">
        </div>

    </form>
</div>
</body>
</html>