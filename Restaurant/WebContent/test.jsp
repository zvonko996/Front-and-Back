<%@page import="rs.Proizvod"%>
<%@page import="rs.DAO"%>
<%@page import="rs.Korisnik"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
ArrayList<Proizvod> lo = (ArrayList<Proizvod>) request.getAttribute("lo");
DAO dao = new DAO();

lo = dao.selectProizvod(2);


for(Proizvod pom: lo)
{
	%>
	<%= pom.getNaziv() %>
	<%= pom.getCena() %>
	<br>
	<%
}
%>
</body>
</html>