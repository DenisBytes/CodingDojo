<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

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
<body>
    <c:out value="${book.title}"></c:out><br>
    <c:out value="${book.description}"></c:out><br>
    <c:out value="${book.numberOfPages}"></c:out><br>
    <c:out value="${book.language}"></c:out><br>

</body>
</html>
