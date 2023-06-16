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
  <title>Tacos</title>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
  <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="container d-flex justify-content-center align-items-center">
  <h1>${showCategory.name}</h1>
</div>
<a href="/">home</a>


<h1>Products:</h1>
<c:forEach var="product" items="${products}">
  <p>${product.name}</p>
</c:forEach>

<form action="/categories/${showCategory.id}" method="post">
  <h4>Add Product:</h4>
  <select name="productId">
    <c:forEach var="product" items="${notProducts}">
      <option value="${product.id}">${product.name}</option>
    </c:forEach>
  </select>
  <input type="submit" value="Add"/>
</body>
</html>
