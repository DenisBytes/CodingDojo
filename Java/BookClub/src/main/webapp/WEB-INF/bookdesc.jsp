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
  <h1>${book.title}</h1>
  <a href="/books">back to the shelves</a>
</div>
<c:if test="${loggedInUserId.equals(book.user.id)}">
  <h2>You read ${book.title}</h2>
  <h3>Here are your thoughts:</h3>
</c:if>
<c:if test="${!loggedInUserId.equals(book.user.id)}">
  <h2>${book.user.userName} read ${book.title} by ${book.author}</h2>
  <h3>Here are ${book.user.userName} thoughts:</h3>
</c:if>
<div class="container border-bottom border-top border-dark">
  <p>
    ${book.thoughts}
  </p>
</div>
<c:if test="${loggedInUserId.equals(book.user.id)}">
  <a href="/books/edit/${book.id}"><button>edit</button></a>
  <form action="/books/delete/${book.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
  </form>
</c:if>
</body>
</html>
