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
<body class="d-flex flex-column justify-content-center align-items-center">
<h1>Dorms</h1>
<div class="container">
  <a href="/dorms">Dashboard</a>
  <form:form action="/students/new" method="post" modelAttribute="student">
    <table>
      <tr>
        <td>
          <form:label path="name">Name:</form:label>
          <form:errors path="name"></form:errors>
        </td>
        <td><form:input path="name"></form:input></td>
        <td>
          <form:label path="dorm">Select Dorm:</form:label>
          <form:errors path="dorm"></form:errors>
        </td>
        <td><form:select path="dorm">
          <c:forEach var="i" items="${dorms}">
            <form:option value="${i.id}">${i.name}</form:option>
          </c:forEach>
        </form:select></td>
      </tr>
      <tr><input type="submit" value="Add"/></tr>
    </table>
  </form:form>
</div>
</body>
</html>
