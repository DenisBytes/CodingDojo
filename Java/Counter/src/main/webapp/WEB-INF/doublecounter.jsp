<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
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
<h2>You have visited <a href="http://localhost:8080/your_server">http://your_server</a> <c:out value="${doubleNumber}"></c:out> times</h2>
<h2><a href="http://localhost:8080/your_server">test another visit?</a></h2>
</body>
</html>