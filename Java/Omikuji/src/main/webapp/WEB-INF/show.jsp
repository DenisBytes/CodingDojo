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
<body class="d-flex justify-content-center flex-column">
    <div class="container w-50 p-4 bg-primary">
        <p>
            In <c:out value="${number}"></c:out> years, you will live
            in <c:out value="${city}"></c:out> with <c:out value="${personName}"></c:out> as your roomate,
            <c:out value="${hobby}"></c:out> for a living.
            The next time you see a <c:out value="${livingThing}"></c:out>, you will have good look.
            Also, <c:out value="${somethingNice}"></c:out>
        </p>
    </div>
    <div class="d-flex justify-content-center align-items-center">
        <a href="http://localhost:8080/omikuji">Go back</a>
    </div>
</body>
</html>