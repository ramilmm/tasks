<%--
  Created by IntelliJ IDEA.
  User: Лия
  Date: 08.10.2015
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title></title>
  </head>
  <body>

  <p> <c:out value="hello, Vasya"/></p>
  <a href="${pageContext.request.contextPath}/test">Test Servlet</a>
  </body>
</html>
