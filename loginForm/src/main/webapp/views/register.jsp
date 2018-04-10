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


<div class="container" >
    <div class="row">
        <div class="col-md-7 offset-md-2 mt-5 p-5 rounded" style="background-color: #B09B74">

            <form action="/register" method="post">
                <h4 style="color:#6C757D ">Uzupełnij dane</h4>
                <div class="form-group pt-3">
                    <input type="text" class="form-control" required name="login" placeholder="Nazwa Użytkownika">
                    <label></label>
                    <input type="password" class="form-control" required name="password" placeholder="Hasło">
                    <label></label>
                    <input type="password" class="form-control" required name="confirmPassword" placeholder="Potwierdz Hasło">
                    <label></label>
                    <input type="email" class="form-control" required name="email" placeholder="Email">
                </div>
                <% if(session.getAttribute("showUserConflictInfo")!= null){  %>
                <div class="alert alert-danger alert-dismissible fade show">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    Nazwa użytkownika jest już zajęta
                </div>
                <% session.setAttribute("showUserConflictInfo",null); %>
                <% }%>
                <% if(session.getAttribute("showWarning")!= null){  %>
                <div class="alert alert-danger alert-dismissible fade show">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    Wprowadzone hasła nie pokrywają się
                </div>
                <% session.setAttribute("showWarning",null); %>
                <% }%>
                <span style="font-size: 12px;" >Masz już konto? <a href="/login">Zaloguj się </a></span>
                <button type="submit" class="btn btn-secondary float-right">Rejestracja</button>
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
