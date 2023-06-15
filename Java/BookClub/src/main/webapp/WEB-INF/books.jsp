<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="d-flex justify-content-between">
    <h1>Welcome ${user.userName}!</h1>
    <a href="/">logout</a>
</div>
<div class="d-flex justify-content-between">
 <h3>Books from everyone shelves:</h3>
 <a href="/books/new">+ Add a book to my shelf!</a>
</div>

<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Title</th>
        <th scope="col">Author Name</th>
        <th scope="col">Posted By</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="book" items="${books}">

        <tr>
            <th scope="row"><c:out value="${book.id}"></c:out></th>
            <td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
            <td><c:out value="${book.author}"></c:out></td>
            <td><c:out value="${book.user.userName}"></c:out></td>
        </tr>

    </c:forEach>

    </tbody>
</table>

<a href="/bookmarket">bookmarket</a>
</body>
</html>