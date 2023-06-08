<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <!-- for Bootstrap CSS -->
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
  <!-- For any Bootstrap that uses JS -->
  <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="/css/style.css">
  <script src="/js/script.js"></script>

</head>
<body>
<h1>Song Details</h1>
<p>Title: <c:out value="${song.title}"/></p>
<p>Artist: <c:out value="${song.artist}"/></p>
<p>Rating: <c:out value="${song.rating}"/></p>
<p><a href="/dashboard">Dashboard</a></p>
</body>
</html>
