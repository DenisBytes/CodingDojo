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
  <h1>Project: ${project.title} </h1>
  <a href="/dashboard">Back to dashboard</a>
</div>
<p>Project Lead: ${project.teamLeader.userName}</p>


<div class="container">
  <form:form action="/projects/${project.id}/tasks" method="post" modelAttribute="task">
    <form:label path="text">Add a task ticket for this team: </form:label>
    <form:errors cssClass="text-danger" path="text"></form:errors>
    <form:input path="text"></form:input>

    <input type="submit" class="btn btn-primary" value="Submit">
  </form:form>
</div>

<div class="container">
  <c:forEach var="task" items="${tasks}">
    <h2>Added by ${task.user.userName} at ${task.createdAt}</h2>
    <p>${task.text}</p>
  </c:forEach>
</div>
</body>
</html>
