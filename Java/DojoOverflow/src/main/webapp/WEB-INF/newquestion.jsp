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
<h1>What is your Question</h1>
<a href="/">Dashboard</a>
<form:form  cssClass="form" action="/questions/new" method="post" modelAttribute="question">
  <form:label path="text">Question: </form:label>
  <form:errors cssClass="text-bg-danger" path="text"></form:errors>
  <form:input cssClass="input" path="text"></form:input>

  <label for="listOfTags">Tags: </label>
  <input class="input" name="listOfTags" id="listOfTags"/>

  <input type="submit" value="Sumbit" class="btn btn-primary">
</form:form>
</body>
</html>
