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
    <h1>Home Page</h1>
</div>

<a href="/products/new">New Product</a>
<a href="/categories/new">New Category</a>

<div class="container w-75">
    <div class="row border border-info p-1">
        <div class="col border-end border-info">
            <h2>Products</h2>
        </div>
        <div class="col">
            <h2>Products</h2>
        </div>
    </div>
</div>
<div class="container w-75">
    <div class="row border border-info p-1">
        <div class="col border-end border-info">
            <c:forEach var="product" items="${products}">
                <a href="/products/${product.id}">${product.name}</a>
            </c:forEach>
        </div>
        <div class="col">
            <c:forEach var="category" items="${categories}">
                <a href="/categories/${category.id}">${category.name}</a>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
