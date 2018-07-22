<%@page import="java.util.ArrayList"%>
<%@page import="fr.gtm.op4youMaven.domaine.Youtuber"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- controle, iterations, tests, variables -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- traitement XML -->
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!-- formattage des donnees -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- SQL/JDBC -->
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat+Alternates" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<title>Connexion</title>
</head>
<body>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<a class="navbar-brand" href="#">
				<img alt="op4you" src="https://www.youtube.com/yt/about/media/images/brand-resources/icons/YouTube_icon_full-color.svg" align="left">	
			</a>
		</div>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="#">Accueil</a></li>
        <li><a href="#">Infos</a></li>
        <li><a href="#">Nos partenaires</a></li>
        <li><a href="index.jsp">Se déconnecter</a></li>
      </ul>
    </div>
	</div>
</nav>
<div class="container">
	<% Youtuber yt = (Youtuber) session.getAttribute("monYoutuber"); %>
	
	<h3 class="titre">Bienvenue sur votre page personnelle <%=yt.getPrenom() %></h3><br>
	<div class="panel panel-default">
	  <div class="panel-heading">Liste des Youtubeurs</div>
	  <table class="table">
	  	<tr>
	  		<th>Nom</th>
	  		<th>Prénom</th>
	  		<th>Nom de la chaine Youtube</th>
	  		<th>Nombre d'abonnés</th>
	  	</tr>
	  	<% ArrayList<Youtuber> maListe = (ArrayList<Youtuber>) session.getAttribute("listeYoutuber"); %>
	  	<% for(Youtuber monYt : maListe){
	  		out.println("<tr>");
	  		out.println("<td>"+monYt.getNom()+"</td>");
	  		out.println("<td>"+monYt.getPrenom()+"</td>");
	  		out.println("<td>"+monYt.getNomChaine()+"</td>");
	  		out.println("<td>"+monYt.getNbrAbonnes()+"</td>");
	  		out.println("</tr>");
	  	}
	  	%>
	  </table>
	</div>
</div>
<footer>
	<div class="panel-footer">
		<span class="text-muted">@2018 - copyright : Op4You</span>
	</div>
</footer>
</body>
</html>