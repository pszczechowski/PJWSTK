<%@ page import="model.User" %>
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
        <img src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" width="30" height="30" alt="">
    </a>
    <span>Zalogowany jako ${user.login} (${user.rights})</span>

    <span>
        <% User user = (User) session.getAttribute("user");
        if(user.getRights().equals("user")){ %>
        <a class="btn disabled" href="/premium">Premium</a> &nbsp &nbsp
        <% } else { %>
        <a href="/premium">Premium</a> &nbsp &nbsp
        <% } %>

        <a href="/logout">Wyloguj</a></span>
</nav>

<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3 mt-5 p-5 rounded" style="background-color: #B09B74">

            <p>Stona dostępna dla użytkownika zalogowanego.</p>
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
