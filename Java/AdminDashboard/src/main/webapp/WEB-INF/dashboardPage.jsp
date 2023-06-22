<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Admin Page</title>
</head>
<body>
<div class="d-flex justify-content-between">
  <h1>Welcome to the Admin Page <c:out value="${currentUser.username}"></c:out></h1>

  <form id="logoutForm" method="POST" action="/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Logout!" />
  </form>
</div>

<p>
  First Name: ${currentUser.userName}
</p>
<p>
  Email: ${currentUser.email}
</p>
<p>
  First Name: ${currentUser.userName}
</p>
<p>Signup Date: <fmt:formatDate pattern = "MMMM dd, y" value = "${currentUser.createdAt}" /></p>
<p>Last Sign in: <fmt:formatDate pattern = "MMMM dd, y" value = "${currentUser.lastLogin}" /></p>
</body>
</html>
