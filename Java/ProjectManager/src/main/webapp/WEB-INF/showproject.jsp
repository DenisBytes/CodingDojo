<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Project Manager</title>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
  <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="p-4 bg-light">
<div class="d-flex justify-content-between">
  <h1>Project Details</h1>
  <a href="/dashboard">Back to dashboard</a>
</div>
<div class="container w-100 d-flex justify-content-center">
  <div class="container w-50">
    <div class="d-flex justify-content-around">
      <p>Project: </p>
      <p>${project.title}</p>
    </div>
    <div class="d-flex justify-content-around">
      <p>Description: </p>
      <p>${project.description}</p>
    </div>
    <div class="d-flex justify-content-around">
      <p>Due Date: </p>
      <p>${project.dueDate}</p>
    </div>
    <c:if test="${project.participatedUsers.contains(user)}">
      <div class="d-flex justify-content-around">
        <a href="/projects/${project.id}/tasks">Tasks</a>
      </div>
      <c:if test="${project.teamLeader.id.equals(user.id)}">
        <a href="/projects/delete/${project.id}"><button class="btn btn-primary">Delete</button></a>
      </c:if>
    </c:if>
  </div>
</div>
</body>
</html>
