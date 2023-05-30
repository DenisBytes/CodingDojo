<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>Customer name: <c:out value="${customerName}"></c:out> </h1>
    <h2>Item name: <c:out value="${itemName}"></c:out></h2>
    <h2>Price: <c:out value="${itemPrice}"></c:out></h2>
    <h2>Description: <c:out value="${itemDescription}"></c:out></h2>
    <h2>Vendor: <c:out value="${vendor}"></c:out></h2>
</body>
</html>