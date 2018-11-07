<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<link href="style/style.css" rel="stylesheet" >
 <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
 <script src="bootstrap-3.3.7-dist/jquery-3.2.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<title>Braca Simic</title>
</head>
<body>
<div id="header">
<form class="form-inline" action="KorisnikLog" method="post">
  <div class="form-group">
    <label for="email">Korisnicko ime:</label>
    <input type="text" class="form-control" name="username">
  </div>
  <div class="form-group">
    <label for="pwd">Sifra:</label>
    <input type="password" class="form-control" name="password">
  </div>
  <input type="submit" class="btn btn-danger" name="akcija" value="Prijava">
  ${msg }
  <input id="registracija" type="submit" class="btn btn-success" name="akcija" value="Registracija">
</form>

</div>
</body>
</html>