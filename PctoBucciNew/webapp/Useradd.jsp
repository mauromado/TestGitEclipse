<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jsp per inerimento user</title>
</head>
<body>
	<h1>Creato nuovo utente</h1>
	
	<p>
	Nome: <% String nome = request.getParameter("nome"); out.print(nome); %> </br>
	Cognome: <% String cognome = request.getParameter("cognome"); out.print(cognome); %> </br>
	Paese: <% String paese = request.getParameter("paese"); out.print(paese); %> </br>
	</p>

</body>
</html>