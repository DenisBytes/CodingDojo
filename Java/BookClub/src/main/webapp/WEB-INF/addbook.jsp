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
  <h1>Add a Book to Your Shelf!</h1>
  <a href="/books">back to the shelves</a>
</div>

<div class="container">
  <form:form action="/bookcreate" method="post" modelAttribute="book">
    <table>
      <tr>
        <td>
          <form:label path="title">Title:</form:label>
          <form:errors path="title"></form:errors>
          <form:input path="title"></form:input></td>
        <td>
          <form:label path="author">Author:</form:label>
          <form:errors path="author"></form:errors>
          <form:input path="author"></form:input></td>
        <td>
          <form:label path="thoughts">Thoughts:</form:label>
          <form:errors path="thoughts"></form:errors>
          <form:input type="textarea" path="thoughts"></form:input></td>
        <input type="hidden" name="user" value="${user.id}"/>
        <td><input type="submit" value="Add"/></td>
      </tr>
    </table>
  </form:form>
</div>
</body>
</html>
