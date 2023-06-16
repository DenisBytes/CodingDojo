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
<h1>${question.text}</h1>
<a href="/">Dashboard</a>

<h1>Tags: </h1>
<c:forEach var="tag" items="${question.tags}">
    <p>${tag.subject}</p>
</c:forEach>

<h1>Answers</h1>
<c:forEach var="answer" items="${question.answers}">
    <p>${answer.text}</p>
</c:forEach>

<h1>Add your Answer:</h1>

<form:form action="/questions/${question.id}" method="post" modelAttribute="answer">
    <form:label path="text">Answer: </form:label>
    <form:errors path="text"></form:errors>
    <form:input path="text"></form:input>

    <input type="submit" value="Answer it!">
</form:form>
</body>
</html>
