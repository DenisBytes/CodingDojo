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
<h1>Burger Tracker</h1>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Burger</th>
            <th scope="col">Restaurant</th>
            <th scope="col">Rating (out of 5)</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="i" items="${burgers}">
            <tr>
                <td><c:out value="${i.burgerName}"></c:out></td>
                <td><c:out value="${i.restaurantName}"></c:out></td>
                <td>-<c:out value="${i.rating}"></c:out></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<h1>Add a Burger:</h1>
<div class="container">
    <form:form action="/" method="post" modelAttribute="burger">
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
