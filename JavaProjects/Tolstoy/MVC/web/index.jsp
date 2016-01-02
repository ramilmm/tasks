<%--
  Created by IntelliJ IDEA.
  User: Горендьже
  Date: 31.10.2015
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <jsp:include page="WEB-INF/view/header.jsp"/>
  <c:if test="${place.equals(choice)}">
    <jsp:include page="WEB-INF/view/leftMenu.jsp"/>
  </c:if>
  <jsp:include page="WEB-INF/view/footer.jsp"/>
  <div id="content">
    <h4 align="center"><c:out value="${head}"/></h4>
    <p><c:out value="${author}"/></p>
  </div>

  </body>
</html>
