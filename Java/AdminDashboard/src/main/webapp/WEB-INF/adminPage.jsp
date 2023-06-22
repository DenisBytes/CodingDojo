<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Admin Page</title>
</head>
<body>
<div class="d-flex justify-content-between">
  <h1>Welcome to the Admin Page <c:out value="${currentUser.userName}"></c:out></h1>

  <form id="logoutForm" method="POST" action="/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Logout!" />
  </form>
</div>
<table class="table table-striped">
  <thead>
  <tr>
    <th scope="col">Name</th>
    <th scope="col">Email</th>
    <th scope="col">Action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="user" items="${allUsers}">
    <tr>
      <td>${user.userName}</td>
      <td>${user.email}</td>
      <c:if test="${user.roles.get(0).name.contains('ROLE_ADMIN')}">
        <td>Admin</td>
      </c:if>
      <c:if test="${user.roles.get(0).name.contains('ROLE_USER')}">
        <td><a href="/delete/${user.id}">Delete</a> <a href="/admin/${user.id}">Make Admin</a></td>
      </c:if>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
