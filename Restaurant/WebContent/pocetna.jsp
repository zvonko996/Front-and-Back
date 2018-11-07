<%@page import="rs.Proizvod"%>
<%@page import="java.util.ArrayList"%>
<%@page import="rs.DAO"%>
<%@page import="rs.Korisnik"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	HttpSession sesija = request.getSession();
	Korisnik ulogovan = (Korisnik) sesija.getAttribute("ulogovan");
	if (ulogovan != null) {
		DAO dao = new DAO();

		ArrayList<Proizvod> la = dao.selectAllProizvod();
		ArrayList<Proizvod> lk = (ArrayList<Proizvod>) sesija.getAttribute("lk");
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style/style.css" rel="stylesheet">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="bootstrap-3.3.7-dist/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<title>Braca Simic</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">WebSiteName</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Pocetna</a></li>
				<li><a href="#">O nama</a></li>
				<li><a href="proizvodi.jsp">Proizvodi</a></li>
				<li><a href="korpa.jsp">Korpa</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"><%= ulogovan.getIme()%>
							${ulogovan.prezime }</span></a></li>
				<li><a href="KorisnikLog?akcija=logout"><span
						class="glyphicon glyphicon-log-out"></span> Odjavi se</a></li>
			</ul>
		</div>
	</div>
	</nav>
	Ovde si
</body>
</html>