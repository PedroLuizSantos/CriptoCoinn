<%@page import="api.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>

<title>ADA</title>
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
			<h3>Cardano ADA</h3>
		</div>
		<br> <img class="cardano" src="ada.png"> <br>
		<div class="row">
			<div class="column">
				<div id="atributos" class="card">
					<h4>Nome:</h4>
					<h5>${ada_name}</h5>
				</div>
			</div>

			<div class="column">
				<div id="atributos" class="card">
					<h4 >Valor(usd):</h4>
					<h5>$${ada_price}</h5>
				</div>
			</div>

			<div class="column">
				<div id="atributos" class="card">
					<h4>Market Cap:</h4>
					<h5 class="myDIV">${ada_marketcap}</h5>
					<div class="popup" onclick="myFunction()"> 
					<i class="fa fa-info-circle" style="font-size: 20px"></i> 
					<span class="popuptext" id="myPopup"> Market Cap permite que os investidores entendam o valor relativo de uma criptomoeda em relação às outras.</span>
					</div>
						
				</div>
			</div>
			<div class="column">
				<div id="atributos" class="card">
					<h3>Total Volume:</h3>
					<h5 class="myDIV">${ada_volume}</h5>
				</div>
			</div>
		</div>
		<br>
		<h3>Introdução</h3>
		<p>A Cardano (ADA) é uma plataforma criada em 2015 por Charles
			Hoskinson, co-fundador da Ethereum, e possui um projeto bastante
			ambicioso. Sua intenção é unir as melhores características e
			funcionalidades de todas as mais de 2 mil criptomoedas existentes no
			mundo, resolvendo problemas e oferecendo novas soluções para as
			moedas digitais.</p>
		<h3>Objetivos</h3>
		<p>Foi criado pela empresa de desenvolvimento de blockchain Input
			Output Hong Kong (IOHK) e liderado por Charles Hoskinson,
			ex-co-fundador da BitShares, Ethereum e Ethereum Classic, e tem como
			objetivo executar contratos inteligentes, aplicativos
			descentralizados, cadeias laterais, computação multipartidária, e
			metadados.</p>
		<h3>Desenvolvimento</h3>
		<p>Cardano foi lançado em 29 de setembro de 2017 na fase de
			bootstrap 'Byron' com o lançamento oficial no Japão. Cardano
			desenvolve sua moeda em torno de uma arquitetura inter-redes
			recursivas (RINA). Cardano usa Haskell, uma linguagem de programação
			com alto grau de tolerância a falhas.</p>
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

.cardano {
	display: block;
	margin-left: auto;
	margin-right: auto;
	border-radius: 30%;
	padding: 5px;
	width: 150px;
}

.bg {
	background-image: url("Fundo.png")
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
	width: 250px;
	background-color: #555;
	color: #fff;
	text-align: center;
	border-radius: 6px;
	padding: 8px 0;
	position: absolute;
	z-index: 1;
	bottom: 125%;
	left: 50%;
	margin-left: -125px;
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