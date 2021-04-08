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
		<h3>Sobre o site</h3>
		<p>Projeto referente a disciplina de Prática Profissional com Dados.</p>
		<p>Usaremos a linguagem de programação Java para esta aplicação, pegaremos dados das cripto moedas e mostraremos os dados correspondentes e algumas de suas características.</p>

		<div class="foto">
			<img class="logo" src="./PaginaInicial"/>
		</div>
		<br>
	</div>
	
	<div>
		
	</div>
	
	<div class="row gx-5">
		<form action="Mostrar" method="get">
		
		<div class="mb-3">
		<label>Valor Um</label>
		<input class="form-control" type="number" name="preco_Moeda">
		</div>
		<button class="btn btn-primary" type="submit" value="preco" name="mostrapreco">Ver Preço</button>
		
		</form>
	</div>

<style>

.logo{
  border: 3px solid;
  border-radius: 10px;
  padding: 5px;
  width: 300px;
  position:right;
}
.card {
	background-color: black;
	color:gold;
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