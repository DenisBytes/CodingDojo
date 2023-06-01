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
    <div class="container w-50 p-4">
        <form class="d-flex flex-column justify-content-center w-75 p-4" action="/omikuji/send" method="post">
            <label>pick any number from 5 to 25</label>
            <input type="number" name="number">
            <label>Enter the name of any city</label>
            <input type="text" name="city">
            <label>Enter the name of any real person</label>
            <input type="text" name="personName">
            <label>Enter professional endeavor or hobby</label>
            <input type="text" name="hobby">
            <label>Enter any type of living thing</label>
            <input type="text" name="livingThing">
            <label>Say something nice to someone</label>
            <input type="" name="somethingNice">
            <p class="font-italic">Send and show a friend</p>
            <div class="d-flex justify-content-center align-items-center">
                <button class="btn btn-primary" type="submit">Send</button>
            </div>
        </form>
    </div>
</body>
</html>