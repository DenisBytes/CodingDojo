<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<html>
<head>
    <meta charset="UTF-8">
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- For any Bootstrap that uses JS -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/css/style.css">
    <script src="/js/script.js"></script>

    <title>Title</title>
</head>
<body class="p-4 d-flex flex-column">
<div class="d-flex justify-content-between">
<h1>Add a Burger:</h1>
<h3><a href="http://localhost:8080">Go back</a></h3>
</div>
<div class="container">
    <form:form action="/burgers/${burger.id}" method="post" modelAttribute="burger">
        <input type="hidden" name="_method" value="put">
        <p>
            <form:label path="burgerName">Burger Name</form:label>
            <form:errors path="burgerName"/>
            <form:input path="burgerName"/>
        </p>
        <p>
            <form:label path="restaurantName">Restaurant name</form:label>
            <form:errors path="restaurantName"/>
            <form:textarea path="restaurantName"/>
        </p>
        <p>
            <form:label path="rating">Rating</form:label>
            <form:errors path="rating"/>
            <form:input type="number" path="rating"/>
        </p>
        <p>
            <form:label path="notes">Notes</form:label>
            <form:errors path="notes"/>
            <form:input path="notes"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>
</div>
</body>
</html>
