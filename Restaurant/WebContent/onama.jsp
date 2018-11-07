<%@page import="rs.DAO"%>
<%@page import="rs.Proizvod"%>
<%@page import="java.util.ArrayList"%>
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
<link href="stylee/style.css" rel="stylesheet" >
<link rel="icon" href="http://www.myiconfinder.com/uploads/iconsets/256-256-007bcbfbd7c9d2c7d7b4b021ee745e22.png" type="image/gif" sizes="16x16" >
<meta name="description" content="Free Web tutorials">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="John Doe">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">

<script src="bootstrap-3.3.7-dist/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<title>Zalogaj</title>

</head>
<body >

	<nav class="navbar navbar-inverse"
		style="border-radius: 0px; margin: 0px;">
		<div class="container">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li><a href="pocetna.jsp">Pocetna</a></li>
						<li class="active"><a href="onama.jsp">O nama</a></li>
						<li><a href="proizvodi.jsp">Proizvodi</a></li>
						<li><a href="korpa.jsp">Korpa</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#"><span class="glyphicon glyphicon-user"><%=ulogovan.getIme()%>
									${ulogovan.prezime }</span></a></li>
						<li><a href="KorisnikLog?akcija=logout"><span
								class="glyphicon glyphicon-log-out"></span> Odjavi se</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>

	<!-- ZVONKO -->
	<div class="modal fade" id="zvonkoModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="exampleModalLabel" align="center">Zvonko
						Simic</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p style="text-align: center">Student informacionih
						tehnologija. Interesovanje mi je web programiranje sa kojim se
						bavim vec 2 godine, rad na raznim projektima. U slobodno vreme
						druzim se sa prijateljima i bavim se sportom.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- FILIP -->
	<div class="modal fade" id="filipModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel" align="center">Filip
						Krstic</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					Student fakulteta tehnickih nauka u Cacku. <br> Treca godina
					studija.<br> Projektni rad iz predmeta <b>internet
						programiranje</b>.
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<!-- DJORDJE -->
	<div class="modal fade" id="djordjeModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel" align="center">Djordje
						Tokalic</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					Student fakulteta tehnickih nauka u Cacku. <br> Treca godina
					studija.<br> Projektni rad iz predmeta <b>internet
						programiranje</b>.
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>


	<div id="kontejner">
	<div id="kont">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<h1 style="text-align: center">O nama</h1><br>
				</div>
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<h4 style="width:90%;text-align: center; margin:auto;">Restoran je otvoren 2018. godine u centru grada Cacka, sa
						ciljem da uvede savremene tehnologije poslovanja na nase podrucje.
						Nasim korisnicima nudimo obiman izbor hrane pripremljene od strane
						najboljih, svetski poznatih kuvara uz mogucnost dostave na kucnu
						adresu.</h4><br>
				</div>
				<div style="text-align: center;" class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<h2 >Direktori restorana:</h2><br>
				</div>
				<div class="koj">
				<div id="mod" class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
				 <div  data-toggle="modal" data-target="#zvonkoModal"><h4>Zvonko Simic</h4></div>
				</div>
				<div id="mod" class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
				<div data-toggle="modal" data-target="#filipModal"><h4>Filip Krstic</h4></div>
				</div>
				<div id="mod" class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
				<div  data-toggle="modal" data-target="#djordjeModal"><h4>Djordje Tokalic</h4></div>
				</div>
				</div>
			</div><br><br>
			
		</div>
		
		<div id="kont">
		<div class="row" id="rr" >
		<div  class="col-xs-12 col-sm-12 col-md-4 col-lg-4"><h4>Adresa: Cara Lazara 78,<br>
Cacak 32000 Srbija</h4></div>
		<div  class="col-xs-12 col-sm-12 col-md-4 col-lg-4"><h4>Telefon:<br>
064/525-33-78
<br><br>
Email:<br>
restoran@gmali.com</h4></div>
		<div  class="col-xs-12 col-sm-12 col-md-4 col-lg-4"><h4>Radno vreme:<br>
Ponedeljak-Subota:<br>
07:00 &#8211; 00:00<br>

Nedelja:
07:00 &#8211; 18:00</h4></div>
		</div>
		</div>
	</div>

	<!-- FOOTER -->
	<div style="background: black; color: white">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div id="share" style="margin: 0px">


						<ul class="social-network social-circle">
							<li><a href="#" class="icoRss" title="Rss"> <i
									class="fa fa-rss"></i>
							</a></li>
							<li><a href="#" class="icoFacebook" title="Facebook"> <i
									class="fa fa-facebook"></i>
							</a></li>
							<li><a href="#" class="icoTwitter" title="Twitter"> <i
									class="fa fa-twitter"></i>
							</a></li>

						</ul>
					</div>
				</div>
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<h5 style="text-align: center;">ZFD @ Sva prava zadrzana</h5>

				</div>
			</div>
		</div>
	</div>
</body>
<%
	} else {
		sesija.invalidate();
		response.sendRedirect("prijava.jsp");
	}
%>
<style>

#kontejner{
border: solid 1px black;
width:90%;
margin: 50px auto;
border-radius: 20px;
box-shadow: 0px 10px 25px 0px rgb(156, 156, 156);
}

#mod{
text-align: center;
width: 30%;
margin-left: 25px;
cursor: pointer;
}

#mod:hover{
 background-color: rgb(66, 66, 66);
    color: white;
    
}

#kont{
 width: 90%;
    margin: 50px auto;
    border-radius: 5px;
    transition: box-shadow ease 0.5s;
}

#kont:hover{
    box-shadow: 5px 10px 20px 5px rgb(173, 173, 173);
}

@media screen and (max-width: 960px){
#mod{
width: 90%;
margin-left: 30px;
}
}

@media screen and (max-width: 550px){
#mod{
width: 85%;
margin-left: 25px;
}
}

#rr{
width:80%; 
margin:auto;
}


}
</style>


</html>

