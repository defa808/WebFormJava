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
    <script src = "https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body style="padding:20px;">
<%
    Map<String, String> dictionaryValues = (Map<String, String>) request.getAttribute("dictionaryValues");
    ArrayList<String> dictionaryErrors = (ArrayList<String>) request.getAttribute("dictionaryErrors");

    if (dictionaryValues != null) {
        for (String key : dictionaryValues.keySet()) {
            System.out.println(key + " - " + dictionaryValues.get(key));
        }
        System.out.println("=====================");
        for(String value : dictionaryErrors){
            System.out.println(value + " ");
        }
    }else{
        dictionaryValues = new HashMap<String,String>();
        dictionaryErrors = new ArrayList<String>();
    }

%>
<h2 style="text-align: center;">Регистрация</h2>
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
                           value="<%=dictionaryValues.getOrDefault("name", "")%>">
                    <span style="color:red;"><%=dictionaryErrors.contains("name")? "Input correct" : ""%></span>

                </div>

                <div class="form-group">
                    <label for="surname">Ваша фамилия*</label>
                    <input type="text" class="form-control" id="surname" name="surname"
                           placeholder="Введите фамилия" value="<%=dictionaryValues.getOrDefault("surname", "")%>">
                    <span style="color:red;"><%=dictionaryErrors.contains("surname")? "Input correct" : ""%></span>
                </div>

                <div class="form-group">
                    <label for="patronymic">Ваше отчество*</label>
                    <input type="text" class="form-control" id="patronymic" name="patronymic"
                           placeholder="Введите отчество" value="<%=dictionaryValues.getOrDefault("patronymic", "")%>">
                    <span style="color:red;"><%=dictionaryErrors.contains("patronymic")? "Input correct" : ""%></span>
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
                           placeholder="Введите login" value="<%=dictionaryValues.getOrDefault("login", "")%>">
                    <span style="color:red;"><%=dictionaryErrors.contains("login")? "Input correct" : ""%></span>

                </div>
                <div class="form-group">
                    <label for="email">Email*</label>
                    <input type="email" class="form-control" id="email" name="email"
                           placeholder="Введите email" value="<%=dictionaryValues.getOrDefault("email", "")%>">
                    <span style="color:red;"><%=dictionaryErrors.contains("email")? "Input correct" : ""%></span>

                </div>
            </div>
            <div class="col-lg-6 col-md-12 col-sm-12">
                <div class="form-group">
                    <label for="homeNumber">Ваш домашний номер*</label>
                    <input type="text" class="form-control" id="homeNumber" name="homeNumber"
                           placeholder="Например: 5-10-20" value="<%=dictionaryValues.getOrDefault("homeNumber", "")%>">
                    <span style="color:red;"><%=dictionaryErrors.contains("homeNumber")? "Input correct" : ""%></span>

                </div>

                <div class="form-group">
                    <label for="mobileNumber">Ваш мобильный номер*</label>
                    <input type="text" class="form-control" id="mobileNumber" name="mobileNumber"
                           placeholder="Например: 099-111-11-11" value="<%=dictionaryValues.getOrDefault("mobileNumber", "")%>">
                    <span style="color:red;"><%=dictionaryErrors.contains("mobileNumber")? "Input correct" : ""%></span>

                </div>

                <div class="form-group">
                    <label for="mobileNumber2">Ваш второй мобильный номер </label>
                    <input type="text" class="form-control" id="mobileNumber2" name="mobileNumber2"
                           placeholder="Например: 099-111-11-11" value="<%=dictionaryValues.getOrDefault("mobileNumber2", "")%>">
                    <span style="color:red;"><%=dictionaryErrors.contains("mobileNumber2")? "Input correct" : ""%></span>

                </div>

                <div class="form-group">
                    <label for="skype">Ваш логин от skype </label>
                    <input type="text" class="form-control" id="skype" name="skype"
                           placeholder="Ваш логин skype" value="<%=dictionaryValues.getOrDefault("skype", "")%>">
                    <span style="color:red;"><%=dictionaryErrors.contains("skype")? "Input correct" : ""%></span>

                </div>

                <div class="form-group">
                    <label>Ваш домашний адрес</label>

                    <label for="index">Ваш домашний индекс</label>
                    <input type="text" class="form-control" id="index" name="index"
                           placeholder="Ваш индекс" value="<%=dictionaryValues.getOrDefault("index", "")%>">
                    <span style="color:red;"><%=dictionaryErrors.contains("index")? "Input correct" : ""%></span>

                    <label for="cityOfResidence">Ваш город</label>
                    <input type="text" class="form-control" id="cityOfResidence" name="cityOfResidence"
                           placeholder="Ваш город" value="<%=dictionaryValues.getOrDefault("cityOfResidence", "")%>">
                    <span style="color:red;"><%=dictionaryErrors.contains("cityOfResidence")? "Input correct" : ""%></span>

                    <label for="street">Ваша улица проживания</label>
                    <input type="text" class="form-control" id="street" name="street"
                           placeholder="Ваша улица проживания" value="<%=dictionaryValues.getOrDefault("street", "")%>">
                    <span style="color:red;"><%=dictionaryErrors.contains("street")? "Input correct" : ""%></span>

                    <label for="houseNumber">Ваш номер дома</label>
                    <input type="text" class="form-control" id="houseNumber" name="houseNumber"
                           placeholder="Ваш номер дома" value="<%=dictionaryValues.getOrDefault("houseNumber", "")%>">
                    <span style="color:red;"><%=dictionaryErrors.contains("houseNumber")? "Input correct" : ""%></span>

                    <label for="apartmentNumber">Ваш номер квартиры</label>
                    <input type="text" class="form-control" id="apartmentNumber" name="apartmentNumber"
                           placeholder="Ваш номер квартиры" value="<%=dictionaryValues.getOrDefault("apartmentNumber", "")%>">
                    <span style="color:red;"><%=dictionaryErrors.contains("apartmentNumber")? "Input correct" : ""%></span>

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
