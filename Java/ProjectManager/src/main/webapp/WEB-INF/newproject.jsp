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
  <h1>Create a Project</h1>
  <a href="/dashboard">Dashboard</a>
</div>

<div class="container rounded">
  <form:form action="/projects/new" method="post" modelAttribute="project">

    <div class="row border border-primary p-1">
      <div class="col border-end border-primary">
        <form:label path="title">Project Title: </form:label>
        <form:errors cssClass="text-danger" path="title"></form:errors>
      </div>
      <div class="col">
        <form:input cssClass="w-100" path="title"></form:input>
      </div>
    </div>

    <div class="row border border-primary p-1">
      <div class="col border-end border-primary">
        <form:label path="description">Project Description: </form:label>
        <form:errors cssClass="text-danger" path="description"></form:errors>
      </div>
      <div class="col">
        <form:input cssClass="w-100" type="textarea" path="description"></form:input>
      </div>
    </div>

    <div class="row border border-primary p-1">
      <div class="col border-end border-primary">
        <form:label path="dueDate">Due Date: </form:label>
        <form:errors cssClass="text-danger" path="dueDate"></form:errors>
      </div>
      <div class="col">
        <form:input cssClass="w-100" type="date" path="dueDate"></form:input>
      </div>
    </div>

    <div class="d-flex justify-content-center align-items-center row border border-primary p-1 w-100">
      <input class="w-25 btn btn-primary" type="submit" value="Sumbit">
    </div>

  </form:form>
</div>
</body>
</html>
