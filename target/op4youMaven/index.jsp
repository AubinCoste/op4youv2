<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
        <li><a href="#">S'inscrire</a></li>
        <li><a href="#">Infos</a></li>
        <li><a href="#">Nos partenaires</a></li>
      </ul>
    </div>
	</div>
</nav>
<div class="container">
	<div class="form-wrapper">
		<h3 class="titre">Bienvenue</h3>
		<form method="post" action="connexion">
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">Login</span>
			  <input type="text" class="form-control" aria-describedby="basic-addon1" name="loginuser">
			</div>
			<div class="input-group">
			  <span class="input-group-addon" id="basic-addon2">Mot de passe</span>
			  <input type="password" class="form-control" aria-describedby="basic-addon2" name="mdpuser">
			</div>
			<div class="input-group">
				<input type="submit" value="se connecter" class="form-control"> 
			</div>
			
		</form>
	</div>
</div>
<footer>
	<div class="panel-footer">
		<span class="text-muted">@2018 - copyright : Op4You</span>
	</div>
</footer>
</body>
</html>