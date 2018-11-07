<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<link href="style/style.css" rel="stylesheet" >
 <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
 <script src="bootstrap-3.3.7-dist/jquery-3.2.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<title>Braca Simic</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
     
      <ul class="nav navbar-nav navbar-right">
        <li><a href="KorisnikLog?akcija=logout"><span class="glyphicon glyphicon-log-in"></span> Prijava</a></li>
      </ul>
    </div>
  </div>
</nav>

<form id="registru" class="form-horizontal" action="KorisnikLog" method="post">
  <div class="form-group">
    <label for="email">Ime:</label>
    <input type="text" class="form-control" name="ime">
  </div>
  <div class="form-group">
    <label for="pwd">Prezime:</label>
    <input type="text" class="form-control" name="prezime">
  </div>
  <div class="form-group">
    <label for="pwd">Adresa:</label>
    <input type="text" class="form-control" name="adresa">
  </div>
  <div class="form-group">
    <label for="pwd">Email:</label>
    <input type="email" class="form-control" name="email">
  </div>
  <div class="form-group">
    <label for="pwd">Username:</label>
    <input type="text" class="form-control" name="username">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" name="password">
  </div>
  <input type="submit" class="btn btn-danger" name="akcija" value="Registrujte se">
  <h1 style="color:red;text-align:center;">${msg }</h1>
</form>
</body>
</html>