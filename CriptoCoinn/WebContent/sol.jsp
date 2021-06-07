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

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>SOL</title>
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
			<h3>Solana</h3>
		</div>
		<br> <img class="sol" src="sol.png"> <br>
		<div class="row">
			<div class="column">
				<div id="atributos" class="card">
					<h4>Nome:</h4>
					<h5>${sol_name}</h5>
				</div>
			</div>

			<div class="column">
				<div id="atributos" class="card">
					<h4>Valor(usd):</h4>
					<h5>$${sol_price}</h5>
				</div>
			</div>

			<div class="column">
				<div id="atributos" class="card">
					<h4>Market Cap:</h4>
					<h5 class="myDIV">${sol_marketcap}</h5>
					<div class="popup" onclick="myFunction()">
					<i class="fa fa-info-circle" style="font-size: 20px"></i> 
					<span class="popuptext" id="myPopup">Informações!</span>
					</div>
				</div>
			</div>
			<div class="column">
				<div id="atributos" class="card">
					<h3>Total Volume:</h3>
					<h5 class="myDIV">${sol_volume}</h5>
				</div>
			</div>
		</div>
		<br>
		<h3>Introdução</h3>
		<p>A Solana é uma plataforma blockchain projetada para concorrer
			com o Ethereum no mercado financeiro institucional. Por exemplo, a
			plataforma é a base da Serum, uma exchange de derivativos.</p>
		<h3>Como Funciona ?</h3>
		<p>SOL é um token nativo da rede Solana. A moeda é usada para o
			trabalho do ecossistema, para que os usuários possam apostá-la. Os
			validadores são escolhidos de acordo com a quantidade de SOL que
			possuem. Quanto mais tokens SOL na conta, maior a chance de obter a
			recompensa por uma transação.</p>
		<h3>História</h3>
		<p>O projeto Solana foi criado em 2017 por Anatoly Yakovenko, que
			era desenvolvedor de software no Dropbox. Sua equipe tenta criar um
			protocolo diferenciado com maior escalabilidade. Para atingir esse
			objetivo, há muitos recursos que Solana usa.</p>
		<h3>Objetivo</h3>
		<p>O objetivo do projeto Solana é muito relevante. Aumentar a
			largura de banda da rede é um verdadeiro desafio para a maioria das
			plataformas atualmente no mercado. O projeto pode se tornar um
			verdadeiro concorrente de qualquer outro meio de pagamento se os
			desenvolvedores atingirem seu objetivo principal.</p>
	</div>
	<br>
	<script>
		// When the user clicks on div, open the popup
		function myFunction() {
			var popup = document.getElementById("myPopup");
			popup.classList.toggle("show");
		}
		
		let x = document.querySelectorAll(".myDIV");
        for (let i = 0, len = x.length; i < len; i++) {
            let num = Number(x[i].innerHTML).toLocaleString('en');
            x[i].innerHTML = num;
            x[i].classList.add("currSign");
        }
		
	</script>

</body>
<br>
<footer>
	<div class="footer">
		<p>CriptoCoin 2020 &copy</p>
	</div>
</footer>

<style>
.currSign:before {
    content: '$';
}
p {
	text-indent: 40px;
}

.sol {
	display: block;
	margin-left: auto;
	margin-right: auto;
	border-radius: 30%;
	padding: 5px;
	width: 150px;
}

.bg {
	background-image: url("Fundo.png");
	background-color: #778899;
}
/* Popup container - can be anything you want */
.popup {
	position: relative;
	display: inline-block;
	cursor: pointer;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

/* The actual popup */
.popup .popuptext {
	visibility: hidden;
	width: 160px;
	background-color: #555;
	color: #fff;
	text-align: center;
	border-radius: 6px;
	padding: 8px 0;
	position: absolute;
	z-index: 1;
	bottom: 125%;
	left: 50%;
	margin-left: -80px;
}

/* Popup arrow */
.popup .popuptext::after {
	content: "";
	position: absolute;
	top: 100%;
	left: 50%;
	margin-left: -5px;
	border-width: 5px;
	border-style: solid;
	border-color: #555 transparent transparent transparent;
}

/* Toggle this class - hide and show the popup */
.popup .show {
	visibility: visible;
	-webkit-animation: fadeIn 1s;
	animation: fadeIn 1s;
}

/* Add animation (fade in the popup) */
@
-webkit-keyframes fadeIn {
	from {opacity: 0;
}

to {
	opacity: 1;
}

}
@
keyframes fadeIn {
	from {opacity: 0;
}

to {
	opacity: 1;
}

}

/* Float columns side by side */
.column {
	float: left;
	width: 25%;
	padding: 0 9px;
}
/* Remove extra left and right margins, due to padding*/
.row {
	margin: 0 -5px;
}
/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}
/* Responsive columns */
@media screen and (max-width: 600px) {
	.column {
		width: 100%;
		display: block;
		margin-bottom: 20px;
	}
}
/* Style the counter cards */
#atributos {
	padding: 10px;
	text-align: center;
	font-family: consolas;
	background-color: #363636;
}

div.sticky {
	background-image: url("Fundo.png");
	top: 0;
	background-color: #363636;
	padding: 50px;
	font-size: 20px;
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

.container-fluid {
	width: 50%;
	color: gold;
	text-align: center;
}

.navbar {
	background-image: url("Fundo.png");
	width: 100%;
	font-family: consolas;
	font-size: 30px;
	color: WHITE;
	text-align: center;
}

.footer {
	background-image: url("Fundo.png");
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
</html>