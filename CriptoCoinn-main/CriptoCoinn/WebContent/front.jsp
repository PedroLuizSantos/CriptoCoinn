<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seja Bem Vindo a CriptoCoin</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
	crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
	
</head>
<body class="bg">

	<nav class="navbar">
		<a class="nav-link active" aria-current="page"
			href="http://localhost:8080/CriptoCoinn/front.jsp#">HOME</a> <a
			class="nav-link" href="http://localhost:8080/CriptoCoinn/ada">ADA</a>
		<a class="nav-link" href="http://localhost:8080/CriptoCoinn/bnb">BNB</a>
		<a class="nav-link" href="http://localhost:8080/CriptoCoinn/chz">CHZ</a>
		<a class="nav-link" href="http://localhost:8080/CriptoCoinn/dot">DOT</a>
		<a class="nav-link" href="http://localhost:8080/CriptoCoinn/sol">SOL</a>
	</nav>
	<br>

	<div class="card">
	<div class="sticky">
			<h3>Sobre o Site</h3>
		</div>
		<br>
		<h5>Projeto referente a disciplina de Prática Profissional com
			Dados.</h5>
		<h5>Usaremos a linguagem de programação Java para esta aplicação,
			pegaremos dados das cripto moedas e mostraremos os dados
			correspondentes e algumas de suas características.</h5>
			<br>
			
		<h4>Membros do Grupo</h4>
  			<h5>Bruno Biscaia</h5>
  			<h5>Gabriel Brunatti</h5>
  			<h5>Luiz Lucas</h5>
  			<h5>Pedro Luiz</h5>
	</div>
	<br>

	<footer>
		<div class="footer">
			<p>CriptoCoin 2020 &copy</p>
		</div>
	</footer>


	<style>

div.sticky {
	background-image: url("Fundo.png");
	top: 0;
	background-color: #363636;
	padding: 50px;
	font-size: 20px;
}
.bg {
	background-image: url("Fundo.png")
}

p {
	text-indent: 40px;
}

.foto {
	display: block;
	opacity: 0.5;
	margin-left: auto;
	margin-right: auto;
	padding: 5px;
}

.card {
	background-color: #696969;
	color: gold;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	max-width: 90%;
	height: 100%;
	margin: auto;
	text-align: center;
	font-family: consolas;
}

.nav-link {
	color: gold;
}

.navbar {
	background-image: url("Fundo.png");
	background-repeat: no-repeat;
	width: 100%;
	font-family: consolas;
	font-size: 30px;
	color: WHITE;
	text-align: center;
}

.footer {
	background-image: url("Fundo.png");
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	height: 25px;
	color: gold;
	font-family: consolas;
	font-size: 15px;
	text-align: center;
}
</style>
</body>
</html>