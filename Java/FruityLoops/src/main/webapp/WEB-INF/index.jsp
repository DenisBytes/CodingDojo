<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
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
<body class="d-flex justify-content-center">
    <div class="container w-50 p-4 mt-5 bg-danger">
        <table class="table bg-white">
            <tbody>
                <tr>
                    <td>Name</td>
                    <td>Price</td>
                </tr>
                <c:forEach var="fruit" items="${fruits}">
                    <c:if test="${fruit.name.startsWith('G')}">
                        <tr>
                            <td class="orange"><c:out value="${fruit.name}"></c:out></td>
                            <td class="orange"><c:out value="${fruit.price}"></c:out></td>
                        </tr>
                    </c:if>
                    <c:if test="${!fruit.name.startsWith('G')}">
                        <tr>
                            <td><c:out value="${fruit.name}"></c:out></td>
                            <td><c:out value="${fruit.price}"></c:out></td>
                        </tr>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>