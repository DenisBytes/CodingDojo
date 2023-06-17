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
  <h1>Welcome, ${user.userName}!</h1>
  <a href="/">LogOut</a>
</div>

<div class="d-flex justify-content-between">
  <h2>All projects</h2>
  <a href="/projects/new"><button class="btn btn-primary">+ New Project</button></a>
</div>
<table class="table table-striped">
  <thead>
  <tr>
    <th scope="col">Project</th>
    <th scope="col">Team Leader</th>
    <th scope="col">Due Date</th>
    <th scope="col">Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="project" items="${projectsNotContains}">
    <tr>
      <th scope="row"><a href="/projects/${project.id}">${project.title}</a></th>
      <td>${project.teamLeader.userName}</td>
      <td>${project.dueDate}</td>
      <td><a href="/jointeam/${project.id}">Join Team</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<h2>Your Projects:</h2>
<table class="table table-striped">
  <thead>
  <tr>
    <th scope="col">Project</th>
    <th scope="col">Team Leader</th>
    <th scope="col">Due Date</th>
    <th scope="col">Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="project" items="${projectsContains}">
    <tr>
      <td><a href="/projects/${project.id}">${project.title}</a></td>
      <td>${project.teamLeader.userName}</td>
      <td>${project.dueDate}</td>
      <c:if test="${project.teamLeader.id.equals(user.id)}">
        <td><a href="/projects/edit/${project.id}">edit</a></td>
      </c:if>
      <c:if test="${!project.teamLeader.id.equals(user.id)}">
        <td><a href="/leaveteam/${project.id}">Leave team</a></td>
      </c:if>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
