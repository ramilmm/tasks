<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Лия
  Date: 08.10.2015
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%
    List<String> list = (List<String>) request.getAttribute("list");
    String errText = (String) request.getAttribute("Error");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form ACTION="${pageContext.request.contextPath}/test" method="post">
    <label>
        <input type="text" name="Name">
    </label>
    <label>
        <input type="submit" name="button" value="OK">
    </label>
</form>
    <c:if test="${errText != null}" >
        <p style="color: #ff4bf6;"><c:out value="errText"/></p>
    </c:if>
    <c:choose>
        <c:when test="${(list == null) || list.isEmpty()}">
            List is empty
        </c:when>
        <c:otherwise>
            <ul>
            <c:forEach items="${list}" var="i">
                <li><c:out value="${i}"/></li>
                <input type="submit" value="delete"/>
                <c:remove var="i"/>
            </c:forEach>
            </ul>
        </c:otherwise>
    </c:choose>
</body>
</html>
