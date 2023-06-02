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
<body class="p-4">
    <h1>Your Gold: <c:out value="${gold}"></c:out></h1>
    <div class="container d-flex justify-content-around">
        <form action="/elaborate" method="post">
            <div class="card text-center m-3">
                <div class="card-header">
                    Farm
                </div>
                <div class="card-body">
                    <h5 class="card-title">(earns 10-20 gold)</h5>
                    <input type="hidden" name="place" value="farm">
                    <button class="btn btn-primary">Find Gold!</button>
                </div>
            </div>
        </form>
        <form action="/elaborate" method="post">
            <div class="card text-center m-3">
                <div class="card-header">
                    Cave
                </div>
                <div class="card-body">
                    <h5 class="card-title">(earns 5-10 gold)</h5>
                    <input type="hidden" name="place" value="cave">
                    <button class="btn btn-primary">Find Gold!</button>
                </div>
            </div>
        </form>
        <form action="/elaborate" method="post">
            <div class="card text-center m-3">
                <div class="card-header">
                    House
                </div>
                <div class="card-body">
                    <h5 class="card-title">(earns 2-5 gold)</h5>
                    <input type="hidden" name="place" value="house">
                    <button class="btn btn-primary">Find Gold!</button>
                </div>
            </div>
        </form>
        <form action="/elaborate" method="post">
            <div class="card text-center m-3">
                <div class="card-header">
                    Quest
                </div>
                <div class="card-body">
                    <h5 class="card-title">(earns/takes 0-50 gold)</h5>
                    <input type="hidden" name="place" value="quest">
                    <button class="btn btn-primary">Find Gold!</button>
                </div>
            </div>
        </form>
        <form action="/elaborate" method="post">
            <div class="card text-center m-3">
                <div class="card-header">
                    Spa
                </div>
                <div class="card-body">
                    <h5 class="card-title">(takes 5-20 gold)</h5>
                    <input type="hidden" name="place" value="spa">
                    <button class="btn btn-primary">Spend Gold!</button>
                </div>
            </div>
        </form>
    </div>

    <div class="d-flex justify-content-center">
        <form action="/reset" method="post">
            <button class="btn btn-primary" type="submit">Reset</button>
        </form>
    </div>

    <h1>Activities: </h1>
    <div class="container w-100 h-100 border-2 cursor-pointer">
        <c:forEach var="activity" items="${activities}">
            <c:set var="isEarned" value="${activity.contains('earned')}" />
            <c:if test="${isEarned}">
                <p class="green"><c:out value="${activity}" /></p>
            </c:if>
            <c:if test="${!isEarned}">
                <p class="red"><c:out value="${activity}" /></p>
            </c:if>
        </c:forEach>
    </div>
</body>
</html>