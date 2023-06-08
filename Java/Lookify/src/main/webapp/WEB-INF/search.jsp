<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <!-- for Bootstrap CSS -->
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
  <!-- For any Bootstrap that uses JS -->
  <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="/css/style.css">
  <script src="/js/script.js"></script>

</head>
<body>
<h1>Songs by <c:out value="${searchTerm}"></c:out></h1>
<table class="table table-striped">
  <thead>
  <tr>
    <th>Name</th>
    <th>Rating</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="song" items="${songs}">
    <tr>
      <td><a href="/songs/${song.id}"><c:out value="${song.title}"></c:out></a></td>
      <td><c:out value="${song.rating}"></c:out></td>
      <td><a href="/songs/delete/${song.id}"><c:out value="delete"></c:out></a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<p><a href="/dashboard">Dashboard</a></p>
</body>
</html>
