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
  <h1>You are in prison. You lost.</h1>
  <h1>Click button to reset and play again.</h1>
  <div class="d-flex justify-content-center">
    <form action="/reset" method="post">
      <button class="btn btn-primary" type="submit">Reset</button>
    </form>
  </div>
</body>
</html>