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
<h1>Safe Travels</h1>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Expenses</th>
            <th scope="col">Vendor</th>
            <th scope="col">Amount</th>
            <th scope="col">Action</th>
            <th scope="col">Cancel</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="i" items="${travels}">
            <tr>
                <td><c:out value="${i.expense}"></c:out></td>
                <td><c:out value="${i.vendor}"></c:out></td>
                <td>$<c:out value="${i.amount}"></c:out></td>
                <td><a href="/expenses/${i.id}/edit">edit</a></td>
                <td>
                    <form action="/expenses/${i.id}" method="post">
                        <input type="hidden" name="_method" value="delete">
                        <input class="btn btn-danger" type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<h1>Add an Expense:</h1>
<div class="container">
    <form:form action="/expenses" method="post" modelAttribute="travel">
        <p>
            <form:label path="expense">Expense</form:label>
            <form:errors path="expense"/>
            <form:input path="expense"/>
        </p>
        <p>
            <form:label path="vendor">Vendor</form:label>
            <form:errors path="vendor"/>
            <form:input path="vendor"/>
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
