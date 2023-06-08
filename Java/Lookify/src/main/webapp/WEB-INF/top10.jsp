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
<div class="container">
  <div class="row">
    <div class="col-sm">Top Ten Songs:</div>
    <div class="col-sm">
      <a href="/dashboard">Dashboard</a>
    </div>
  </div>
  <table class="table table-bordered">
    <tbody>
    <c:forEach items="${songs}" var="song">
      <tr>
        <td><c:out value="${song.rating}" /></td>
        <td><a href="/songs/${song.id}"><c:out
                value="${song.title}" /></a></td>
        <td><c:out value="${song.artist}" /></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
