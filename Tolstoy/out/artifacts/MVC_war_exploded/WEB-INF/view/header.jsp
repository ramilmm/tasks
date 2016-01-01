<%--
  Created by IntelliJ IDEA.
  User: Горендьже
  Date: 31.10.2015
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
  ul.hr {
    margin: 0; /* Обнуляем значение отступов */
    margin-left: 20px;
    padding: 10px; /* Значение полей */
  }
  ul.hr li {
    display: inline; /* Отображать как строчный элемент */
    margin-right: 40px; /* Отступ слева */
  }
  #header {
    position: absolute;
    top: 1px;
    left: 100px;
    background-color: #228b22;
    width: 80%
  }
</style>

<div id="header">
      <ul class="hr">
        <li><a href="/main">Главная</a></li>
        <li><a href="/article">Статьи</a></li>
        <li><a href="/about">О нас</a></li>
        <li><a href="/contacts">Контакты</a></li>
        <li><a href="/help">Помощь</a></li>
      </ul>
</div>