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
<h1>Add Song</h1>
<form:form action="/songs/new" modelAttribute="song" method="post">
  <div>
    <form:errors path="title"/>
    <form:label path="title" for="title">Title:</form:label>
    <form:input path="title" type="text"/>
  </div>
  <div>
    <form:errors path="artist"/>
    <form:label path="artist" for="artist">Artist:</form:label>
    <form:input path="artist" type="text"/>
  </div>
  <div>
    <form:errors path="rating"/>
    <form:label path="rating" for="rating">Rating (1-10):</form:label>
    <form:input path="rating" type="number"/>
  </div>
  <div>
    <input value="Add" type="submit"/>
  </div>
</form:form>
<p><a href="/dashboard">Dashboard</a></p>
</body>
</html>
