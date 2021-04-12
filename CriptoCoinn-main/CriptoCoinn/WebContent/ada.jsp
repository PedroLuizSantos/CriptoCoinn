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
<body style="background-color: #A9A9A9;">

	<nav class="navbar">
		<a class="nav-link active" aria-current="page"
			href="http://localhost:8080/CriptoCoinn/front.jsp#">HOME</a> <a
			class="nav-link" href="http://localhost:8080/CriptoCoinn/Ada">ADA</a>
		<a class="nav-link" href="http://localhost:8080/CriptoCoinn/bnb.jsp">BNB</a>
		<a class="nav-link" href="http://localhost:8080/CriptoCoinn/chz.jsp">CHZ</a>
		<a class="nav-link" href="http://localhost:8080/CriptoCoinn/dot.jsp">DOT</a>
		<a class="nav-link" href="http://localhost:8080/CriptoCoinn/sol.jsp">SOL</a>
	</nav>

	<br>

	<div class="card">
		<div class="sticky">Cardano ADA</div>
		<div class="foto">
			<img class="cardana" src="./PaginaAda" />
		</div>
		<br>
		<h3>Introdu��o</h3>
		<p>A Cardano (ADA) � uma plataforma criada em 2015 por Charles
			Hoskinson, co-fundador da Ethereum, e possui um projeto bastante
			ambicioso. Sua inten��o � unir as melhores caracter�sticas e
			funcionalidades de todas as mais de 2 mil criptomoedas existentes no
			mundo, resolvendo problemas e oferecendo novas solu��es para as
			moedas digitais. O projeto � definido como a terceira gera��o de
			criptomoedas. Neste racioc�nio, o Bitcoin seria a primeira gera��o, o
			Ethereum a segunda, e a Cardano a terceira gera��o. Um dos principais
			objetivos da Cardano �, usando um blockchain, ser uma moeda digital,
			assim como o Bitcoin. A ideia � servir como um meio de pagamento
			alternativo em pa�ses que dificuldade de acesso a bancos. Para isso,
			um de seus focos � melhorar a velocidade com que as transa��es s�o
			feitas. Al�m disso, a Cardano foi a primeira criptomoeda baseada em
			uma metodologia cient�fica. Isso tr�s mais for�a para seu c�digo, que
			� avaliado e revisado por uma grande equipe de pesquisadores,
			cientistas, engenheiros e desenvolvedores.</p>
		<h3>Objetivos</h3>
		<p>Foi criado pela empresa de desenvolvimento de blockchain Input
			Output Hong Kong (IOHK) e liderado por Charles Hoskinson,
			ex-co-fundador da BitShares, Ethereum e Ethereum Classic, e tem como
			objetivo executar contratos inteligentes, aplicativos
			descentralizados, cadeias laterais, computa��o multipartid�ria, e
			metadados.</p>
		<h3>Plataforma</h3>
		<p>As moedas s�o extra�das e as decis�es s�o tomadas atrav�s de um
			algoritmo de prova de participa��o chamado Ouroboros, em vez de um
			sistema de prova de trabalho. O consenso � gerado pelo voto do
			titular da moeda. Nesse protocolo, os l�deres de slots geram novos
			blocos no blockchain e verificam as transa��es. Qualquer pessoa
			segurando uma moeda Ada pode se tornar um l�der de slot.</p>
		<h3>Camadas</h3>
		<p>O moeda Ada opera em seu pr�prio blockchain chamado o Camada de
			estabelecimento de Cardano (CSL). O CSL � uma camada de contabilidade
			e suporta transa��es cont�beis. Uma segunda camada chamada CCA
			(Cardano Computation Layer - Camada de Computa��o Cardano) suportar�
			contratos inteligentes e aplicativos descentralizados.</p>
		<h3>Desenvolvimento</h3>
		<p>Cardano foi lan�ado em 29 de setembro de 2017 na fase de
			bootstrap 'Byron' com o lan�amento oficial no Jap�o. Cardano
			desenvolve sua moeda em torno de uma arquitetura inter-redes
			recursivas (RINA). Cardano usa Haskell, uma linguagem de programa��o
			com alto grau de toler�ncia a falhas.</p>

		<br>
		<div class="row">
			<div class="column">
				<div id="atributos" class="card">
					<h4>Nome: ${ada_name}</h4>
				</div>
			</div>

			<div class="column">
				<div id="atributos" class="card">
					<h4>Simbolo:${ada_symbol}</h4>
				</div>
			</div>

			<div class="column">
				<div id="atributos" class="card">
					<h4>Valor(usd):$${ada_price}</h4>
				</div>
			</div>

			<div class="column">
				<div id="atributos" class="card">
					<h4>Market Cap:${ada_marketcap}</h4>
				</div>
			</div>
			<div class="column">
				<div id="atributos" class="card">
					<h3>Total Volume:${ada_volume}</h3>
				</div>
			</div>
		</div>
		<br>
	</div>
	<br>
</body>
<footer>
	<div class="footer">
		<p>&copyCOPYRIGHT</p>
	</div>
</footer>

<style>
/* Float columns side by side */
.column {
	float: left;
	width: 20%;
	padding: 0 9px;
}
/* Remove extra left and right margins, due to padding */
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
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	padding: 10px;
	text-align: center;
	font-family: consolas;
	background-color: #A9A9A9;
}

div.sticky {
	position: -webkit-sticky;
	position: sticky;
	top: 0;
	background-color: #363636;
	padding: 50px;
	font-size: 20px;
}

.cardana {
	border-radius: 10px;
	padding: 5px;
	width: 250px;
	position: right;
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
	width: 100%;
	background-color: #4F4F4F;
	color: gold;
	text-align: center;
}

.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	height: 20px;
	background-color: #4F4F4F;
	color: gold;
	text-align: center;
}
</style>
</html>