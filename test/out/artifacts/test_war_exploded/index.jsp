<%--
  Created by IntelliJ IDEA.
  User: Горендьже
  Date: 26.10.2015
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%Integer count = (Integer) session.getAttribute("Counter");%>
<html>
<head>
  <title>I umeu schitat</title>
</head>
<body>
<h1>I umeu schitat</h1>
<p> <c:out value="${count}"></c:out> </p>
<form action="/Iumni" method="post">
  <input type="submit" value="GO">
</form>
  </body>
</html>
