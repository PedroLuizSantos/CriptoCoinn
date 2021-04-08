<%@page import="api.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<title>ADA</title>
</head>
<body style="background-color: gold;">

	<nav class="navbar">
		<a class="nav-link active" aria-current="page" href="http://localhost:8080/CriptoCoinn/front.jsp#">HOME</a> 
		<a class="nav-link" href="http://localhost:8080/CriptoCoinn/ada.jsp">ADA</a> 
		<a class="nav-link" href="http://localhost:8080/CriptoCoinn/bnb.jsp">BNB</a>
		<a class="nav-link" href="http://localhost:8080/CriptoCoinn/chz.jsp">CHZ</a> 
		<a class="nav-link" href="http://localhost:8080/CriptoCoinn/dot.jsp">DOT</a>
		<a class="nav-link" href="http://localhost:8080/CriptoCoinn/sol.jsp">SOL</a>
	</nav>
	
	<br>
	<br>
	<br>
	<br>
	
	<div class="card">
		<h3>Cardano ADA</h3>
		<div class="foto">
		<img class="cardana" src="./PaginaAda"/>
		</div>
		<br>
		<p>A Cardano (ADA) é uma plataforma criada em 2015 por Charles Hoskinson, co-fundador da Ethereum, e possui um projeto bastante ambicioso.</p>
		<p>Sua intenção é unir as melhores características e funcionalidades de todas as mais de 2 mil criptomoedas existentes no mundo, resolvendo problemas e oferecendo novas soluções para as moedas digitais.</p>
		<p>O projeto é definido como a terceira geração de criptomoedas. Neste raciocínio, o Bitcoin seria a primeira geração, o Ethereum a segunda, e a Cardano a terceira geração.</p>	
		<br>
		<h2>Ficha Técnica</h2>
		<p>Nome: ${ada_name}</p>
		<p>Simbolo: ${ada_symbol}</p>
		<p>Valor(usd):$  ${ada_price}</p>
		<p>Mareket Cap: ${ada_marketcap}</p>
		<p>Total Volume: ${ada_volume}</p>
	</div>
	
<style>

.cardana{
  border-radius: 10px;
  padding: 5px;
  width: 250px;
  position:right;
}
.card {
	background-color: black;
	color:gold;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	max-width: 90%;
	height: 100%;
	margin: auto;
	text-align:center;
	font-family: consolas;
}

.nav-link {
	color: gold;
}

.navbar {
	width: 100%;
	position: fixed;
	background-color: black;
	color: gold;
	text-align: center;
}

.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	height: 20px;
	background-color: black;
	color: gold;
	text-align: center;
}
</style>

</body>
<footer>
	<div class="footer">
		<p>&copyCOPYRIGHT</p>
	</div>
</footer>
</html>