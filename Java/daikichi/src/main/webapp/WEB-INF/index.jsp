<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="java.util.Date" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <% for (int i = 0; i < 5; i++){ %>
    <h1><%="Hello Future"%></h1>
    <%}%>
    <h3><%= "Today's date: " + new Date()%></h3>
</body>
</html>