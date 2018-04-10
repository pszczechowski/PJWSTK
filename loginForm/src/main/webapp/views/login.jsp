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
        <div class="col-md-6 offset-md-3 mt-5 p-5 rounded" style="background-color: #B09B74">

            <form action="/login" method="post">
                <h4 style="color:#6C757D ">Zaloguje się!</h4>

                <% if(session.getAttribute("showRegistrationInfo")!= null){  %>
                <div class="alert alert-success fade show">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    Konto zostało stworzone. Zaloguje się.
                </div>
                <% session.setAttribute("showRegistrationInfo",null); %>
                <% }%>

                <% if(session.getAttribute("showAuthError") != null){  %>
                <div class="alert alert-danger fade show">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    Błąd sprawdź login lub hasło
                </div>
                <% session.setAttribute("showAuthError",null); %>
                <% }%>
                <div class="form-group pt-3">
                    <p class="h6" style="font-size: 10px">konto administratora -> admin/admin</p>
                    <input type="text" class="form-control" required name="login" placeholder="Login">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" required name="password" placeholder="Hasło">
                </div>
                <span style="font-size: 12px;" >Nie ma konta? <a href="/register">Zarejestruj się </a></span>
                <button type="submit" class="btn btn-secondary float-right">Zaloguj</button>
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
