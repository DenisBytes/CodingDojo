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
<body class="p-4">
<div class="container m-4">
  <h1>New Ninja</h1>
  <form:form action="/ninjas/new" modelAttribute="ninja" method="post">

    <form:label path="dojo">Dojo: </form:label>
    <form:select path="dojo">
      <c:forEach var="i" items="${dojos}">
        <form:option value="${i.id}">${i.name}</form:option>
      </c:forEach>
    </form:select>

    <form:label path="firstName">First Name</form:label>
    <form:errors path="firstName"/>
    <form:input path="firstName"/>

    <form:label path="lastName">First Name</form:label>
    <form:errors path="lastName"/>
    <form:input path="lastName"/>

    <form:label path="age">Age:</form:label>
    <form:errors path="age"/>
    <form:input type="number" path="age"/>

    <input type="submit" class="btn btn-primary" value="Create Ninja">

  </form:form>
</div>
</body>
</html>
