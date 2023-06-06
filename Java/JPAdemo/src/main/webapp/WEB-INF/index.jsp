<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
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
<body>
<h1>Hello Future</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Title</th>
        <th scope="col">Language</th>
        <th scope="col"># Pages</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="i" items="${books}">
            <tr>
                <th scope="row"><c:out value="${i.id}"></c:out></th>
                <td><a href="/books/${i.id}"><c:out value="${i.title}"></c:out></a></td>
                <td><c:out value="${i.description}"></c:out></td>
                <td>-<c:out value="${i.numberOfPages}"></c:out></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
