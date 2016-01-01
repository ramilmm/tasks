<%@ page import="model.Note" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Note> list = (List<Note>) request.getAttribute("list");
  Boolean hasError = (Boolean) request.getAttribute("error");
%>
<html>
<head>
    <title></title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/test" method="post">
    <label>
      Set your name:
      <input type="text" name="name"/>
    </label>
    <label>
      Set your phone:
      <input type="text" name="phone"/>
    </label>
    <label>
      Set your age:
      <input type="text" name="age"/>
    </label>
    <input type="submit" name="set" value="OK"/>
    <%if (Boolean.TRUE.equals(hasError)) {%>
      <br><span style="color: red">name can not be empty!</span>
    <%}%>
  </form>
  <%if (list != null && !list.isEmpty()) {%>
  <ul>
    <pre>Name     Phone number     Age</pre>
    <%for (Note note : list) {%>
      <li><%= note.getFio() + "\t" + note.getPhone() + "\t" + note.getYear()%></li>
    <%}%>
  </ul>
  <%} else {%>
    List is empty!
  <%}%>
</body>
</html>
