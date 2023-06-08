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
<div class="d-flex justify-content-around">
  <div><a href="/songs/new">Add Song</a></div>
  <div><a href="/songs/top">Top Songs</a></div>
  <div>
    <form action="dashboard" method="post">
      <input id="artist" name="artist" placeholder="Search"/>
      <input class="btn btn-success" type="submit" value="Search"/>
    </form>
  </div>
</div>
<table class="table table-striped">
  <thead>
  <tr>
    <th>Name</th>
    <th>Rating</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="song" items="${songs}">
    <tr>
      <td><a href="/songs/${song.id}"><c:out value="${song.title}"></c:out></a></td>
      <td><c:out value="${song.rating}"></c:out></td>
      <td><a href="/songs/delete/${song.id}"><c:out value="delete"></c:out></a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
