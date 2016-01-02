<%--
  Created by IntelliJ IDEA.
  User: Горендьже
  Date: 31.10.2015
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">
  <jsp:include page="header.jsp"/>
  <jsp:include page="leftMenu.jsp"/>
  <jsp:include page="footer.jsp"/>
  <div id="content">
    <h4 align="center"><c:out value="${head}"/></h4>
    <p><c:out value="${author}"/></p>
  </div>
  <style type="text/css">
    #main{
      position: absolute;
      top: 39px;
      left: 305px;
      background-color: #fcfbb1;
      height: 600px;
      width: 65%;
    }
    #content {
      text-align: center;
    }
  </style>
</div>
