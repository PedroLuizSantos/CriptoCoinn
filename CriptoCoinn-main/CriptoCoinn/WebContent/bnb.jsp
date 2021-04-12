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
<title>BNB</title>
</head>
<body style="background-color: gold;">

	<nav class="navbar">
		<a class="nav-link active" aria-current="page" href="http://localhost:8080/CriptoCoinn/front.jsp#">HOME</a> 
		<a class="nav-link" href="http://localhost:8080/CriptoCoinn/Ada">ADA</a> 
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
		<h3>BNB</h3>
		<div class="foto">
		<img class="bnb" src="./PaginaBnb"/>
		</div>
		<br>
		<p>Você já ouviu falar em Binance Coin? Assim como a Bitcoin, é mais uma opção de criptomoeda para quem deseja lidar com o mercado de moedas digitais. Ela é emitida pela bolsa Binance e frequentemente negociada por meio do símbolo BNB.</p>
		<p>Essa moeda digital tem ganhado força e se destacado nas listas das principais criptomoedas existentes.</p>
		<p>A plataforma Binance já é considerada a segunda maior bolsa de moedas digitais do mundo. Ela conta com cerca de 6 bilhões de dólares em ativos sendo negociados a cada semana.</p>	
	</div>

<style>

.bnb{
  border-radius: 10px;
  padding: 5px;
  width: 250px;
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


.navbar {
	width: 100%;
	position: fixed;
	background-color: black;
	color: gold;
	text-align: center;
}
.nav-link {
	color: gold;
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