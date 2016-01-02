<%--
  Created by IntelliJ IDEA.
  User: Горендьже
  Date: 31.10.2015
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="leftmenu">
  <ul id="ul">
    <li class="right">Меню:</li>
    <li class="left">Литература</li>
    <li class="right"><a href="/articles/content?action=Pushkin">Пушкин А.С.</a></li>
    <li class="right"><a href="/articles/content?action=Tolstoy">Толстой Л.Н.</a></li>
    <li class="right"><a href="/articles/content?action=Gogol">Гоголь Н.В.</a></li>
    <li class="right"><a href="/articles/content?action=Esenin">Есенин С.А.</a></li>
    <li class="right"><a href="/articles/content?action=Gete">Гёте И.В.</a></li>
    <li class="left"><a href="/articles/menu?action=movie">Музыка</a></li>
    <li class="left"><a href=/articles/menu?action=music">Кино</a></li>
  </ul>
  <style type="text/css">
    #ul {
      list-style-type: none;
      margin-top: 40px;
    }
    #leftmenu {
      position: absolute;
      top: 39px;
      left: 50px;
      background-color: #ffb6c1;
      margin-left: 50px;
      width: 15%;
      height: 600px;
    }
    li.right {
      text-align: right;
    }
    li.left {
      text-align: left;
    }
  </style>
</div>
