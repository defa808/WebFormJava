<%@ page import="java.util.ArrayList" %>
<%@ page import="main.java.ua.kpi.tef.model.GroupSubscriber" %>
<%@ page import="main.java.ua.kpi.tef.model.Subscriber" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="javax.swing.text.html.HTMLDocument" %>

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
<%
    Map<String, String> dictionary = (Map<String, String>) request.getAttribute("dictionary");
    Boolean flag = false;
    if (dictionary != null) {
        flag = true;
        for (String key : dictionary.keySet()) {
            System.out.println(key + " - " + dictionary.get(key));
        }
    }

%>
<h2>Регистрация asd</h2>
<div class="formWrap"><% if (request.getAttribute("errors") != null) { %>
    <div class="alert alert-danger" role="alert"><%=request.getAttribute("errors") %>
        <% } %>
    </div>
    <form action="RegisterFormServlet" method="POST" role="form">
        <div class="row">
            <div class="col-lg-6 col-md-12 col-sm-12">
                <div class="form-group">
                    <label for="name">Ваше имя*</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Введите имя"
                           value="<%=dictionary.getOrDefault("name", "")%>">

                </div>

                <div class="form-group">
                    <label for="surname">Ваша фамилия*</label>
                    <input type="text" class="form-control" id="surname" name="surname"
                           placeholder="Введите фамилия" value="<%=dictionary.getOrDefault("surname", "")%>">
                </div>

                <div class="form-group">
                    <label for="patronymic">Ваше отчество*</label>
                    <input type="text" class="form-control" id="patronymic" name="patronymic"
                           placeholder="Введите отчество" value="<%=dictionary.getOrDefault("patronymic", "")%>">
                </div>

                <div class="form-group">
                    <label for="sel1">Выберите группу*:</label>
                    <select class="form-control" id="sel1">
                        <option value="Admin">Admin</option>
                        <option value="User">User</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="email">Ваш Логин*</label>
                    <input type="text" class="form-control" id="login" name="login"
                           placeholder="Введите login" value="<%=dictionary.getOrDefault("login", "")%>">
                </div>
                <div class="form-group">
                    <label for="email">Email*</label>
                    <input type="email" class="form-control" id="email" name="email"
                           placeholder="Введите email" value="<%=dictionary.getOrDefault("email", "")%>">
                </div>
            </div>
            <div class="col-lg-6 col-md-12 col-sm-12">
                <div class="form-group">
                    <label for="homeNumber">Ваш домашний номер*</label>
                    <input type="text" class="form-control" id="homeNumber" name="homeNumber"
                           placeholder="Например: 5-10-20" value="<%=dictionary.getOrDefault("homeNumber", "")%>">
                </div>

                <div class="form-group">
                    <label for="mobileNumber">Ваш мобильный номер*</label>
                    <input type="text" class="form-control" id="mobileNumber" name="mobileNumber"
                           placeholder="Например: 099-111-11-11" value="<%=dictionary.getOrDefault("mobileNumber", "")%>">
                </div>

                <div class="form-group">
                    <label for="mobileNumber2">Ваш второй мобильный номер </label>
                    <input type="text" class="form-control" id="mobileNumber2" name="mobileNumber2"
                           placeholder="Например: 099-111-11-11" value="<%=dictionary.getOrDefault("mobileNumber2", "")%>">
                </div>

                <div class="form-group">
                    <label for="skype">Ваш логин от skype </label>
                    <input type="text" class="form-control" id="skype" name="skype"
                           placeholder="Ваш логин skype" value="<%=dictionary.getOrDefault("skype", "")%>">
                </div>

                <div class="form-group">
                    <label>Ваш домашний адрес</label>

                    <label for="index">Ваш домашний индекс</label>
                    <input type="text" class="form-control" id="index" name="index"
                           placeholder="Ваш индекс" value="<%=dictionary.getOrDefault("index", "")%>">
                    <label for="cityOfResidence">Ваш город</label>
                    <input type="text" class="form-control" id="cityOfResidence" name="cityOfResidence"
                           placeholder="Ваш город" value="<%=dictionary.getOrDefault("cityOfResidence", "")%>">
                    <label for="street">Ваша улица проживания</label>
                    <input type="text" class="form-control" id="street" name="street"
                           placeholder="Ваша улица проживания" value="<%=dictionary.getOrDefault("street", "")%>">
                    <label for="houseNumber">Ваш номер дома</label>
                    <input type="text" class="form-control" id="houseNumber" name="houseNumber"
                           placeholder="Ваш номер дома" value="<%=dictionary.getOrDefault("houseNumber", "")%>">
                    <label for="apartmentNumber">Ваш номер квартиры</label>
                    <input type="text" class="form-control" id="apartmentNumber" name="apartmentNumber"
                           placeholder="Ваш номер квартиры" value="<%=dictionary.getOrDefault("apartmentNumber", "")%>">
                </div>
            </div>

        </div>
        <div class="form-group" style="display:flex; justify-content: center;">
            <button type="submit" class="btn btn-success btn-lg">Регистрация</button>
        </div>
    </form>
</div>
</body>
</html>
