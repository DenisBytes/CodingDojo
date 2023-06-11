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
<body class="d-flex flex-column justify-content-center align-items-center">
<h1>${dorm.name} Students</h1>
<div class="container">
  <a href="/dorms">Dashboard</a>
  <table>
    <form:form action="/dorms/${dormsId}" method="put" modelAttribute="dorm">

      <tr>
        <td>

            <form:label path="students">Students</form:label>
            <form:select path="students" multiple="false">
              <c:forEach var="i" items="${students}">
                <form:option value="${i.id}">${i.name} (${i.dorm.name})</form:option>
              </c:forEach>
            </form:select>

        </td>

        <td>
          <input type="submit" value="Add">
        </td>
      </tr>
    </form:form>
  </table>

  <table class="table">
    <thead>
    <tr>
      <td>Student</td>
      <td>Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="i" items="${dorm.students}">
      <tr>
        <c:if test="${i.dormChangeCount % 2 != 0}">
          <td>${i.name} (${i.dorm.name})</td>
        </c:if>
        <c:if test="${i.dormChangeCount % 2 == 0}">
          <td>${i.name}</td>
        </c:if>
        <td><a href="/dorms/remove/${i.id}">Remove</a></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
