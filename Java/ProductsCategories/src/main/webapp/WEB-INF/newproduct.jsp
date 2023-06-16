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
<div class="container d-flex justify-content-center align-items-center">
  <h1>New Product</h1>
</div>
<a href="/">home</a>

<div class="container w-50">
  <form:form action="/addproduct" method="post" modelAttribute="product">

    <div class="row border border-info p-1">
      <div class="col border-end border-info">
        <form:label path="name">Name: </form:label>
        <form:errors cssClass="text-bg-danger" path="name"></form:errors>
      </div>
      <div class="col w-100">
        <form:input path="name"></form:input>
      </div>
    </div>

    <div class="row border border-info p-1">
      <div class="col border-end border-info">
        <form:label path="description">Description: </form:label>
        <form:errors cssClass="text-bg-danger" path="description"></form:errors>
      </div>
      <div class="col w-100">
        <form:input path="description"></form:input>
      </div>
    </div>

    <div class="row border border-info p-1">
      <div class="col border-end border-info">
        <form:label path="price">Price: </form:label>
        <form:errors cssClass="text-bg-danger" path="price"></form:errors>
      </div>
      <div class="col w-100">
        <form:input type="number" path="price"></form:input>
      </div>
    </div>

    <div class="row border border-info p-1 w-100">
      <input type="submit" value="Sumbit">
    </div>
  </form:form>

</div>
</body>
</html>
