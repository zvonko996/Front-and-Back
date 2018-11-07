<%@page import="rs.Proizvod"%>
<%@page import="java.util.ArrayList"%>
<%@page import="rs.DAO"%>
<%@page import="rs.Korisnik"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%
	HttpSession sesija = request.getSession();
	Korisnik ulogovan = (Korisnik) sesija.getAttribute("ulogovan");
	if (ulogovan != null) {
		DAO dao = new DAO();

		ArrayList<Proizvod> la = dao.selectAllProizvod();
		ArrayList<Proizvod> lk = (ArrayList<Proizvod>) sesija.getAttribute("lk");
%>
<head>
<meta charset="UTF-8">
<link href="stylee/style.css" rel="stylesheet">
<script src="bootstrap-3.3.7-dist/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<title>Braca Simic</title>
</head>
<body>

	<nav class="navbar navbar-inverse" style="border-radius: 0px; ">
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
					<li><a href="pocetna.jsp">Pocetna</a></li>
					<li><a href="#">O nama</a></li>
					<li class="active"><a href="proizvodi.jsp">Proizvodi</a></li>
					<li><a href="korpa.jsp">Korpa</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-user"><%=ulogovan.getIme()%>
								<%=ulogovan.getPrezime()%></span></a></li>
					<li><a href="KorisnikLog?akcija=logout"><span
							class="glyphicon glyphicon-log-out"></span> Odjavi se</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<%
				for (Proizvod a : la) {
			%>
			<div  class="col-xs-6 col-sm-6 col-md-4 col-lg-3">
				<img class="img img-responsive" style="height: 200px; width: 100%;"
					src="<%=a.getSlika()%>">
				<h4 >
					<div style="text-align: center"><%= a.getNaziv()%></div><br> Cena: <%= a.getCena() %>din <br>Gramaza: <%= a.getKolicina() %>
					<br>
					<br>
					
					<a class="btn btn-warning" style="width: 100%; color: black"
						href="Prodavnica?action=dodaj&id=<%=a.getId()%>"> Dodaj u
						korpu <span class="glyphicon glyphicon-shopping-cart"></span></a>


				</h4>
			</div>
			<%
				}
			%>
		</div>
		<%
			} else {
				response.sendRedirect("prijava.jsp");
			}
		%>
	</div>



</body>
</html>