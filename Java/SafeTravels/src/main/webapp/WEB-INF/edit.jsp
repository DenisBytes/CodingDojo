<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<html>
<head>
  <meta charset="UTF-8">
  <!-- for Bootstrap CSS -->
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
  <!-- For any Bootstrap that uses JS -->
  <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="/css/style.css">
  <script src="/js/script.js"></script>

  <title>Title</title>
</head>
<body class="p-4 d-flex flex-column">
<div class="d-flex justify-content-between">
  <h1>Edit an Expense</h1>
  <h3><a href="/expenses">Go back</a></h3>
</div>
<div class="container">
  <form:form action="/expenses/${travel.id}" method="post" modelAttribute="travel">
    <input type="hidden" name="_method" value="put">
    <p>
      <form:label path="expense">Expense</form:label>
      <form:errors path="expense"/>
      <form:input path="expense"/>
    </p>
    <p>
      <form:label path="vendor">Vendor</form:label>
      <form:errors path="vendor"/>
      <form:textarea path="vendor"/>
    </p>
    <p>
      <form:label path="amount">Amount</form:label>
      <form:errors path="amount"/>
      <form:input type="text" path="amount"/>
    </p>
    <p>
      <form:label path="description">Description</form:label>
      <form:errors path="description"/>
      <form:input path="description"/>
    </p>
    <input class="btn btn-primary" type="submit" value="Submit"/>
  </form:form>
</div>
</body>
</html>
