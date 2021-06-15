package api;

import java.time.Instant;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyServletContextListener implements ServletContextListener {

	static Coin Cardano = new Coin();
	static Coin Binance = new Coin();
	static Coin Chiliz = new Coin();
	static Coin Polkadot = new Coin();
	static Coin Solana = new Coin();

	public void contextInitialized(ServletContextEvent e) {

		coinGecko coinGecko = new coinGecko();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Coin moeda = new Coin();

		long timeTo = Instant.now().getEpochSecond();
		long timeFromDaily = timeTo - 86400;
		long timeFromWeekly = timeTo - 604800;
		long timeFromMonthly = timeTo - 2592000;

		try {

			Thread threadADA = new ThreadADA(Cardano);
			threadADA.start();

			Thread threadBNB = new ThreadBNB(Binance);
			threadBNB.start();
			
			Thread threadCHZ = new ThreadCHZ(Chiliz);
			threadCHZ.start();
			
			Thread threadDOT = new ThreadDOT(Polkadot);
			threadDOT.start();
			
			Thread threadSOL = new ThreadSOL(Solana);
			threadSOL.start();
			
			moeda = gson.fromJson(coinGecko.bitcoinInfo(), Coin.class);
			moeda.ConverterMarket_Data();
			moeda.transferirMarket_Data();

			Cardano = gson.fromJson(coinGecko.cardanoInfo(), Coin.class);
			Cardano.ConverterMarket_Data();
			Cardano.transferirMarket_Data();

			Cardano.daily_values = gson.fromJson(coinGecko.cardanoMarketValues(timeFromDaily, timeTo),
					Coin.market_values.class);
			Cardano.weekly_values = gson.fromJson(coinGecko.cardanoMarketValues(timeFromWeekly, timeTo),
					Coin.market_values.class);
			Cardano.monthly_values = gson.fromJson(coinGecko.cardanoMarketValues(timeFromMonthly, timeTo),
					Coin.market_values.class);

			Binance = gson.fromJson(coinGecko.binanceInfo(), Coin.class);
			Binance.ConverterMarket_Data();
			Binance.transferirMarket_Data();

			Binance.daily_values = gson.fromJson(coinGecko.binanceMarketValues(timeFromDaily, timeTo),
					Coin.market_values.class);
			Binance.weekly_values = gson.fromJson(coinGecko.binanceMarketValues(timeFromWeekly, timeTo),
					Coin.market_values.class);
			Binance.monthly_values = gson.fromJson(coinGecko.binanceMarketValues(timeFromMonthly, timeTo),
					Coin.market_values.class);

			Chiliz = gson.fromJson(coinGecko.chilizInfo(), Coin.class);
			Chiliz.ConverterMarket_Data();
			Chiliz.transferirMarket_Data();

			Chiliz.daily_values = gson.fromJson(coinGecko.chillizMarketValues(timeFromDaily, timeTo),
					Coin.market_values.class);
			Chiliz.weekly_values = gson.fromJson(coinGecko.chillizMarketValues(timeFromWeekly, timeTo),
					Coin.market_values.class);
			Chiliz.monthly_values = gson.fromJson(coinGecko.chillizMarketValues(timeFromMonthly, timeTo),
					Coin.market_values.class);

			Polkadot = gson.fromJson(coinGecko.polkadotInfo(), Coin.class);
			Polkadot.ConverterMarket_Data();
			Polkadot.transferirMarket_Data();
			
			Polkadot.daily_values = gson.fromJson(coinGecko.polkadotMarketValues(timeFromDaily, timeTo),
					Coin.market_values.class);
			Polkadot.weekly_values = gson.fromJson(coinGecko.polkadotMarketValues(timeFromWeekly, timeTo),
					Coin.market_values.class);
			Polkadot.monthly_values = gson.fromJson(coinGecko.polkadotMarketValues(timeFromMonthly, timeTo),
					Coin.market_values.class);

			Solana = gson.fromJson(coinGecko.solanaInfo(), Coin.class);
			Solana.ConverterMarket_Data();
			Solana.transferirMarket_Data();

			Solana.daily_values = gson.fromJson(coinGecko.solanaMarketValues(timeFromDaily, timeTo),
					Coin.market_values.class);
			Solana.weekly_values = gson.fromJson(coinGecko.solanaMarketValues(timeFromWeekly, timeTo),
					Coin.market_values.class);
			Solana.monthly_values = gson.fromJson(coinGecko.solanaMarketValues(timeFromMonthly, timeTo),
					Coin.market_values.class);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			Cardano.variacaoDiaria = calcularVariacao(Cardano.daily_values.prices.get(0)[1],
					Cardano.daily_values.prices.get(Cardano.daily_values.prices.size() - 1)[1]);
			Cardano.variacaoSemanal = calcularVariacao(Cardano.weekly_values.prices.get(0)[1],
					Cardano.weekly_values.prices.get(Cardano.weekly_values.prices.size() - 1)[1]);
			Cardano.variacaoMensal = calcularVariacao(Cardano.monthly_values.prices.get(0)[1],
					Cardano.monthly_values.prices.get(Cardano.monthly_values.prices.size() - 1)[1]);

			Cardano.variacaoDiariaPorcentagem = calcularVariacaoPorcentagem(Cardano.daily_values.prices.get(0)[1],
					Cardano.daily_values.prices.get(Cardano.daily_values.prices.size() - 1)[1]);
			Cardano.variacaoSemanalPorcentagem = calcularVariacaoPorcentagem(Cardano.weekly_values.prices.get(0)[1],
					Cardano.weekly_values.prices.get(Cardano.weekly_values.prices.size() - 1)[1]);
			Cardano.variacaoMensalPorcentagem = calcularVariacaoPorcentagem(Cardano.monthly_values.prices.get(0)[1],
					Cardano.monthly_values.prices.get(Cardano.monthly_values.prices.size() - 1)[1]);

			Binance.variacaoDiaria = calcularVariacao(Binance.daily_values.prices.get(0)[1],
					Binance.daily_values.prices.get(Binance.daily_values.prices.size() - 1)[1]);
			Binance.variacaoSemanal = calcularVariacao(Binance.weekly_values.prices.get(0)[1],
					Binance.weekly_values.prices.get(Binance.weekly_values.prices.size() - 1)[1]);
			Binance.variacaoMensal = calcularVariacao(Binance.monthly_values.prices.get(0)[1],
					Binance.monthly_values.prices.get(Binance.monthly_values.prices.size() - 1)[1]);

			Binance.variacaoDiariaPorcentagem = calcularVariacaoPorcentagem(Binance.daily_values.prices.get(0)[1],
					Binance.daily_values.prices.get(Binance.daily_values.prices.size() - 1)[1]);
			Binance.variacaoSemanalPorcentagem = calcularVariacaoPorcentagem(Binance.weekly_values.prices.get(0)[1],
					Binance.weekly_values.prices.get(Binance.weekly_values.prices.size() - 1)[1]);
			Binance.variacaoMensalPorcentagem = calcularVariacaoPorcentagem(Binance.monthly_values.prices.get(0)[1],
					Binance.monthly_values.prices.get(Binance.monthly_values.prices.size() - 1)[1]);

			Chiliz.variacaoDiaria = calcularVariacao(Chiliz.daily_values.prices.get(0)[1],
					Chiliz.daily_values.prices.get(Chiliz.daily_values.prices.size() - 1)[1]);
			Chiliz.variacaoSemanal = calcularVariacao(Chiliz.weekly_values.prices.get(0)[1],
					Chiliz.weekly_values.prices.get(Chiliz.weekly_values.prices.size() - 1)[1]);
			Chiliz.variacaoMensal = calcularVariacao(Chiliz.monthly_values.prices.get(0)[1],
					Chiliz.monthly_values.prices.get(Chiliz.monthly_values.prices.size() - 1)[1]);

			Chiliz.variacaoDiariaPorcentagem = calcularVariacaoPorcentagem(Chiliz.daily_values.prices.get(0)[1],
					Chiliz.daily_values.prices.get(Chiliz.daily_values.prices.size() - 1)[1]);
			Chiliz.variacaoSemanalPorcentagem = calcularVariacaoPorcentagem(Chiliz.weekly_values.prices.get(0)[1],
					Chiliz.weekly_values.prices.get(Chiliz.weekly_values.prices.size() - 1)[1]);
			Chiliz.variacaoMensalPorcentagem = calcularVariacaoPorcentagem(Chiliz.monthly_values.prices.get(0)[1],
					Chiliz.monthly_values.prices.get(Chiliz.monthly_values.prices.size() - 1)[1]);

			Polkadot.variacaoDiaria = calcularVariacao(Polkadot.daily_values.prices.get(0)[1],
					Polkadot.daily_values.prices.get(Polkadot.daily_values.prices.size() - 1)[1]);
			Polkadot.variacaoSemanal = calcularVariacao(Polkadot.weekly_values.prices.get(0)[1],
					Polkadot.weekly_values.prices.get(Polkadot.weekly_values.prices.size() - 1)[1]);
			Polkadot.variacaoMensal = calcularVariacao(Polkadot.monthly_values.prices.get(0)[1],
					Polkadot.monthly_values.prices.get(Polkadot.monthly_values.prices.size() - 1)[1]);

			Polkadot.variacaoDiariaPorcentagem = calcularVariacaoPorcentagem(Polkadot.daily_values.prices.get(0)[1],
					Polkadot.daily_values.prices.get(Polkadot.daily_values.prices.size() - 1)[1]);
			Polkadot.variacaoSemanalPorcentagem = calcularVariacaoPorcentagem(Polkadot.weekly_values.prices.get(0)[1],
					Polkadot.weekly_values.prices.get(Polkadot.weekly_values.prices.size() - 1)[1]);
			Polkadot.variacaoMensalPorcentagem = calcularVariacaoPorcentagem(Polkadot.monthly_values.prices.get(0)[1],
					Polkadot.monthly_values.prices.get(Polkadot.monthly_values.prices.size() - 1)[1]);

			Solana.variacaoDiaria = calcularVariacao(Solana.daily_values.prices.get(0)[1],
					Solana.daily_values.prices.get(Solana.daily_values.prices.size() - 1)[1]);
			Solana.variacaoSemanal = calcularVariacao(Solana.weekly_values.prices.get(0)[1],
					Solana.weekly_values.prices.get(Solana.weekly_values.prices.size() - 1)[1]);
			Solana.variacaoMensal = calcularVariacao(Solana.monthly_values.prices.get(0)[1],
					Solana.monthly_values.prices.get(Solana.monthly_values.prices.size() - 1)[1]);

			Solana.variacaoDiariaPorcentagem = calcularVariacaoPorcentagem(Solana.daily_values.prices.get(0)[1],
					Solana.daily_values.prices.get(Solana.daily_values.prices.size() - 1)[1]);
			Solana.variacaoSemanalPorcentagem = calcularVariacaoPorcentagem(Solana.weekly_values.prices.get(0)[1],
					Solana.weekly_values.prices.get(Solana.weekly_values.prices.size() - 1)[1]);
			Solana.variacaoMensalPorcentagem = calcularVariacaoPorcentagem(Solana.monthly_values.prices.get(0)[1],
					Solana.monthly_values.prices.get(Solana.monthly_values.prices.size() - 1)[1]);
		} finally {
			System.out.println(Cardano.variacaoDiaria);
			System.out.println(Cardano.variacaoSemanal);
			System.out.println(Cardano.variacaoMensal);

			System.out.println(Cardano.variacaoDiariaPorcentagem + "%");
			System.out.println(Cardano.variacaoSemanalPorcentagem + "%");
			System.out.println(Cardano.variacaoMensalPorcentagem + "%");
		}

		if (Cardano.variacaoMensalPorcentagem <= -10 && Cardano.variacaoMensalPorcentagem >= -20
				&& Cardano.variacaoDiariaPorcentagem < 10) {
			Cardano.analise = "HORA DE COMPRAR/ANALISAR";
		} else if (Cardano.variacaoMensalPorcentagem >= 5 && Cardano.variacaoMensalPorcentagem <= 10
				&& Cardano.variacaoDiariaPorcentagem > 5) {
			Cardano.analise = "HORA DE COMPRAR";
		} else if (Cardano.variacaoMensalPorcentagem >= 30 && Cardano.variacaoDiariaPorcentagem <= -20) {
			Cardano.analise = "HORA DE COMPRAR";
		} else if (Cardano.variacaoMensalPorcentagem <= -10 && Cardano.variacaoMensalPorcentagem >= -20
				&& Cardano.variacaoDiariaPorcentagem >= 20) {
			Cardano.analise = "HORA DE ANALISAR";
		} else if (Cardano.variacaoMensalPorcentagem <= -20 && Cardano.variacaoDiariaPorcentagem >= 50) {
			Cardano.analise = "HORA DE COMPRAR";
		} else if (Cardano.variacaoMensalPorcentagem >= 20 && Cardano.variacaoDiariaPorcentagem >= 50) {
			Cardano.analise = "HORA DE VENDER/ANALISAR";
		} else {
			Cardano.analise = "HORA DE ANALISAR";
		}

		System.out.println(Cardano.analise);

		if (Binance.variacaoMensalPorcentagem <= -10 && Binance.variacaoMensalPorcentagem >= -20
				&& Binance.variacaoDiariaPorcentagem < 10) {
			Binance.analise = "HORA DE COMPRAR/ANALISAR";
		} else if (Binance.variacaoMensalPorcentagem >= 5 && Binance.variacaoMensalPorcentagem <= 10
				&& Binance.variacaoDiariaPorcentagem > 5) {
			Binance.analise = "HORA DE COMPRAR";
		} else if (Binance.variacaoMensalPorcentagem >= 30 && Binance.variacaoDiariaPorcentagem <= -20) {
			Binance.analise = "HORA DE COMPRAR";
		} else if (Binance.variacaoMensalPorcentagem <= -10 && Binance.variacaoMensalPorcentagem >= -20
				&& Binance.variacaoDiariaPorcentagem >= 20) {
			Binance.analise = "HORA DE ANALISAR";
		} else if (Binance.variacaoMensalPorcentagem <= -20 && Binance.variacaoDiariaPorcentagem >= 50) {
			Binance.analise = "HORA DE COMPRAR";
		} else if (Binance.variacaoMensalPorcentagem >= 20 && Binance.variacaoDiariaPorcentagem >= 50) {
			Binance.analise = "HORA DE VENDER/ANALISAR";
		} else {
			Binance.analise = "HORA DE ANALISAR";
		}

		if (Chiliz.variacaoMensalPorcentagem <= -10 && Chiliz.variacaoMensalPorcentagem >= -20
				&& Chiliz.variacaoDiariaPorcentagem < 10) {
			Chiliz.analise = "HORA DE COMPRAR/ANALISAR";
		} else if (Chiliz.variacaoMensalPorcentagem >= 5 && Chiliz.variacaoMensalPorcentagem <= 10
				&& Chiliz.variacaoDiariaPorcentagem > 5) {
			Chiliz.analise = "HORA DE COMPRAR";
		} else if (Chiliz.variacaoMensalPorcentagem >= 30 && Chiliz.variacaoDiariaPorcentagem <= -20) {
			Chiliz.analise = "HORA DE COMPRAR";
		} else if (Chiliz.variacaoMensalPorcentagem <= -10 && Chiliz.variacaoMensalPorcentagem >= -20
				&& Chiliz.variacaoDiariaPorcentagem >= 20) {
			Chiliz.analise = "HORA DE ANALISAR";
		} else if (Chiliz.variacaoMensalPorcentagem <= -20 && Chiliz.variacaoDiariaPorcentagem >= 50) {
			Chiliz.analise = "HORA DE COMPRAR";
		} else if (Chiliz.variacaoMensalPorcentagem >= 20 && Chiliz.variacaoDiariaPorcentagem >= 50) {
			Chiliz.analise = "HORA DE VENDER/ANALISAR";
		} else {
			Chiliz.analise = "HORA DE ANALISAR";
		}

		if (Polkadot.variacaoMensalPorcentagem <= -10 && Polkadot.variacaoMensalPorcentagem >= -20
				&& Polkadot.variacaoDiariaPorcentagem < 10) {
			Polkadot.analise = "HORA DE COMPRAR/ANALISAR";
		} else if (Polkadot.variacaoMensalPorcentagem >= 5 && Polkadot.variacaoMensalPorcentagem <= 10
				&& Polkadot.variacaoDiariaPorcentagem > 5) {
			Polkadot.analise = "HORA DE COMPRAR";
		} else if (Polkadot.variacaoMensalPorcentagem >= 30 && Polkadot.variacaoDiariaPorcentagem <= -20) {
			Polkadot.analise = "HORA DE COMPRAR";
		} else if (Polkadot.variacaoMensalPorcentagem <= -10 && Polkadot.variacaoMensalPorcentagem >= -20
				&& Polkadot.variacaoDiariaPorcentagem >= 20) {
			Polkadot.analise = "HORA DE ANALISAR";
		} else if (Polkadot.variacaoMensalPorcentagem <= -20 && Polkadot.variacaoDiariaPorcentagem >= 50) {
			Polkadot.analise = "HORA DE COMPRAR";
		} else if (Polkadot.variacaoMensalPorcentagem >= 20 && Polkadot.variacaoDiariaPorcentagem >= 50) {
			Polkadot.analise = "HORA DE VENDER/ANALISAR";
		} else {
			Polkadot.analise = "HORA DE ANALISAR";
		}

		if (Solana.variacaoMensalPorcentagem <= -10 && Solana.variacaoMensalPorcentagem >= -20
				&& Solana.variacaoDiariaPorcentagem < 10) {
			Solana.analise = "HORA DE COMPRAR/ANALISAR";
		} else if (Solana.variacaoMensalPorcentagem >= 5 && Solana.variacaoMensalPorcentagem <= 10
				&& Solana.variacaoDiariaPorcentagem > 5) {
			Solana.analise = "HORA DE COMPRAR";
		} else if (Solana.variacaoMensalPorcentagem >= 30 && Solana.variacaoDiariaPorcentagem <= -20) {
			Solana.analise = "HORA DE COMPRAR";
		} else if (Solana.variacaoMensalPorcentagem <= -10 && Solana.variacaoMensalPorcentagem >= -20
				&& Solana.variacaoDiariaPorcentagem >= 20) {
			Solana.analise = "HORA DE ANALISAR";
		} else if (Solana.variacaoMensalPorcentagem <= -20 && Solana.variacaoDiariaPorcentagem >= 50) {
			Solana.analise = "HORA DE COMPRAR";
		} else if (Solana.variacaoMensalPorcentagem >= 20 && Solana.variacaoDiariaPorcentagem >= 50) {
			Solana.analise = "HORA DE VENDER/ANALISAR";
		} else {
			Solana.analise = "HORA DE ANALISAR";
		}

	}

	public double calcularVariacao(double valorInicial, double valorFinal) {
		double variacao = 0;

		variacao = valorFinal - valorInicial;

		return variacao;
	}

	public double calcularVariacaoPorcentagem(double valorInicial, double valorFinal) {
		double variacao = 0;
		variacao = ((valorFinal / valorInicial) * 100) - 100;
		return variacao;
	}

	public void contextDestroyed(ServletContextEvent e) {

	}

}
