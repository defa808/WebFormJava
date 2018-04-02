<%@ page import="java.util.ArrayList" %>
<%@ page import="main.java.ua.kpi.tef.model.GroupSubscriber" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: alexg
  Date: 26.03.2018
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрационная форма</title>
    <link rel="stylesheet" type="text/css" href="Content/bootstrap.min.css">
</head>
<body>
<h2>Регистрация asd</h2>
<div class="formWrap" style="width:50%;">
    <form action="Servlet" method="POST" role="form">

        <div class="form-group">
            <label for="name">Ваше имя</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Введите имя">
        </div>

        <div class="form-group">
            <label for="surname">Ваша фамилия</label>
            <input type="text" class="form-control" id="surname" name="surname" placeholder="Введите фамилия">
        </div>

        <div class="form-group">
            <label for="patronymic">Ваше отчество</label>
            <input type="text" class="form-control" id="patronymic" name="patronymic" placeholder="Введите отчество">
        </div>

        <div class="form-group">
            <label for="sel1">Select list:</label>
            <select class="form-control" id="sel1">
                <option value="Admin">Admin</option>
                <option value="User">User</option>
            </select>
        </div>

        <div class="form-group">
            <label for="email">Ваш Логин</label>
            <input type="text" class="form-control" id="login" name="login" placeholder="Введите login">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Введите email">
        </div>

        <div class="form-group">
            <label for="homeNumber">Ваш домашний номер</label>
            <input type="text" class="form-control" id="homeNumber" name="homeNumber" placeholder="Например: 5-10-20">
        </div>

        <div class="form-group">
            <button type="submit" style="float:right;" class="btn btn-success">Регистрация</button>
        </div>
    </form>
</div>
</body>
</html>
