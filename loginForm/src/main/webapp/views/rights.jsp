<%@ page import="model.User" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Formularz</title>
</head>
<body style="background-color:#595959;background-image: url('https://www.transparenttextures.com/patterns/food.png')">
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="/index">
        <img src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" width="35" height="35" alt="">
    </a>
    <span>Zalogowany jako ${user.login} ${user.rights}</span>

    <span>
        <% User user = (User) session.getAttribute("user");
            if(!user.getRights().equals("administrator")){ %>
        <a class="btn disabled" href="/rights">Premium</a> &nbsp &nbsp
        <% } else { %>
        <a href="/premium">Premium </a> &nbsp &nbsp
        <% }%>

        <a href="/logout">Wyloguj</a></span>
</nav>

<div class="container">
    <div class="row">
        <div class="col-md-7 offset-md-3 mt-5 p-5 rounded" style="background-color:#FFFFFF">


            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Login</th>
                    <th scope="col">Email</th>
                    <th scope="col">Uprawnienia</th>
                    <th scope="col">Akcje</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${allUsers}" var="user">

                <tr>
                    <td>${user.login}</td>
                    <td>${user.email}</td>
                    <td>${user.rights}</td>
                    <td><a href="/delete?user=${user.login}"> <img style="width: 15px; height: 15px" src="http://files.softicons.com/download/toolbar-icons/flatastic-icons-part-1-by-custom-icon-design/png/512x512/delete.png"></a></td>
                </tr>

                </c:forEach>
                </tbody>
            </table>

            <p class="font-weight-bold">Zmiana uprawnień</p>
            <form action="/rights" method="post">
                <select name="userToChange">
                    <c:forEach items="${allUsers}" var="user">
                    <option value="${user.login}">${user.login}</option>
                    </c:forEach>
                </select>
                <select name="newRights">
                    <option value="user">User</option>
                    <option value="premium">Premium</option>
                </select>
                <button class="btn btn-primary btn-sm" type="submit">Zatwierdz</button>

            </form>
        </div>

    </div>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
